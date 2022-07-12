package com.engeto.projekt2;

import com.engeto.projekt2.entity.Country;
import com.engeto.projekt2.service.CountryService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication()
public class Application {
    private static ApplicationContext applicationContext;
    private static CountryService countryService;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Application.class, args);
        countryService = applicationContext.getBean(CountryService.class);

        // Load rates by HTTP Request
        loadInputRates();

        // Read user input from console
        readUserInput();
    }

    public static void loadInputRates() {
        try {
            // Get Request to obtain current rates
            RestTemplate restTemplate = new RestTemplate();
            String ratesJson = restTemplate.getForObject("https://euvatrates.com/rates.json", String.class);

            // Parse response
            ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getFactory();
            JsonParser parser = factory.createParser(ratesJson);
            JsonNode obj = mapper.readTree(parser);

            // Save found countries to database
            Iterator<Map.Entry<String, JsonNode>> nodes = obj.get("rates").fields();
            while (nodes.hasNext()) {
                Map.Entry<String, JsonNode> entry = nodes.next();

                String nameShort = entry.getKey();
                JsonNode node = entry.getValue();
                String comment = null;
                String isoDuplicateOf = null;

                String nameLong = node.get("country").toString();
                if (node.has("_comment")) {
                    comment = node.get("_comment").toString();
                }
                if (node.has("iso_duplicate")) {
                    isoDuplicateOf = node.get("iso_duplicate").toString();
                }

                BigDecimal standardRate = tryParseBigDecimal(node.get("standard_rate").toString());
                BigDecimal reducedRate = tryParseBigDecimal(node.get("reduced_rate").toString());
                BigDecimal reducedRateAlt = tryParseBigDecimal(node.get("reduced_rate_alt").toString());
                BigDecimal superReducedRate = tryParseBigDecimal(node.get("super_reduced_rate").toString());
                BigDecimal parkingRate = tryParseBigDecimal(node.get("parking_rate").toString());

                Country country = new Country(nameShort, nameLong, comment, isoDuplicateOf, standardRate, reducedRate, reducedRateAlt, superReducedRate, parkingRate);
                country = countryService.saveCountry(country);
                System.out.println("Country successfully saved. ID: " + country.getId() + ", Name: " + country.getNameLong());
            }
        } catch (Exception e) {
            System.out.println("Error occurred during load of input rates to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void readUserInput() {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        // Read user input until blank value is entered.
        do {
            //  Prompt for the user's input
            System.out.print("Enter country name abbreviation to look up: ");

            userInput = scanner.nextLine();
            Country countryByNameShort;
            String output = "";

            // Try lookup the country and return its available rates
            try {
                countryByNameShort = countryService.getFirstCountryByNameShort(userInput.toUpperCase().trim());
                output = output + "Country Name: " + countryByNameShort.getNameLong() + "\n";
                BigDecimal rateTmp;

                rateTmp = countryByNameShort.getStandardRate();
                if (rateTmp != null)
                    output = output + "Standard Rate: " + rateTmp + "\n";

                rateTmp = countryByNameShort.getReducedRate();
                if (rateTmp != null)
                    output = output + "Reduced Rate: " + rateTmp + "\n";

                rateTmp = countryByNameShort.getReducedRateAlt();
                if (rateTmp != null)
                    output = output + "Reduced Rate Alt: " + rateTmp + "\n";

                rateTmp = countryByNameShort.getSuperReducedRate();
                if (rateTmp != null)
                    output = output + "Super Reduced Rate: " + rateTmp + "\n";

                rateTmp = countryByNameShort.getParkingRate();
                if (rateTmp != null)
                    output = output + "Parking Rate: " + rateTmp + "\n";

                System.out.println(output);
            } catch (NoSuchElementException e) {
                System.out.println("Given country was not found in the database. '" + userInput + "'");
                continue;
            }
            System.out.println("----------------------------------");
            System.out.print("Do you want to save the country rates to a file? Y/N?: ");
            userInput = scanner.nextLine();
            if (!(userInput.toUpperCase().trim().equals("Y")))
                continue;

            System.out.println("----------------------------------");
            System.out.print("Please enter target text file save path including filename: ");
            userInput = scanner.nextLine();

            // Try to write to file
            try {
                // Create file if it does not exist
                File file = new File(userInput);
                if (!file.exists()) {
                    file.createNewFile();
                }

                // Write to file
                BufferedWriter writer = new BufferedWriter(new FileWriter(userInput));
                writer.write(output);
                writer.close();
                System.out.println("Writing to file was successful. FilePath: '" + userInput + "'");
            } catch (IOException e) {
                System.out.println("Error occurred during writing to file. FilePath: '" + userInput + "'");
            }
            System.out.println("----------------------------------");
        } while (StringUtils.hasText(userInput));
    }

    public static BigDecimal tryParseBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
