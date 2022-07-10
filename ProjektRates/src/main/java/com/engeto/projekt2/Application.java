package com.engeto.projekt2;

import com.engeto.projekt2.entity.Country;
import com.engeto.projekt2.repository.CountryRepository;
import com.engeto.projekt2.service.CountryService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@SpringBootApplication()
public class Application {
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(Application.class, args);

        loadInputRates();
    }

    public static void loadInputRates() {
        CountryService countryService = applicationContext.getBean(CountryService.class);

        try {
            RestTemplate restTemplate = new RestTemplate();
            String ratesJson = restTemplate.getForObject("https://euvatrates.com/rates.json", String.class);

            //System.out.println("Result: " + ratesJson);

            ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getFactory();
            JsonParser parser = factory.createParser(ratesJson);
            JsonNode obj = mapper.readTree(parser);

            Iterator<Map.Entry<String, JsonNode>> nodes = obj.get("rates").fields();
            while (nodes.hasNext()) {
                Map.Entry<String, JsonNode> entry = nodes.next();
                //System.out.println(entry.getKey() + " value-->" + entry.getValue());

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
                System.out.println(country.getId());
            }

        } catch (Exception e) {
            System.out.println("Error occured during load of input rates: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static BigDecimal tryParseBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
