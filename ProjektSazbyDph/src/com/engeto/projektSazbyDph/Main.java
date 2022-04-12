package com.engeto.projektSazbyDph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter Threshold VAT Rate : ");
        String inputRate = null;
        try {
            inputRate = reader.readLine();
            if (inputRate.isEmpty() || !(Integer.parseInt(inputRate) >= 0)) {
                throw new IOException("Invalid input rate");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Entered VAT Rate: " + inputRate);
        Countries.setThresholdVatRate(Integer.parseInt(inputRate));

        // Loading input file
        FileOperations.LoadListFromFile("src/com/engeto/projektSazbyDph/vat-eu.csv");

        // Print all countries
        //System.out.println("Printing All:");
        //Countries.printAllCountries();

        ArrayList<Country> countries = Countries.getCountryListAboveRate();
        Countries.sort(countries);
        countries = Countries.getCountryListBelowRate();
        Countries.sort(countries);

        // Print countries with VAT higher than threshold
        //System.out.println("Printing countries above threshold:");
        Countries.printAllCountriesVatAboveThreshold();
        System.out.println("====================");
        Countries.printAllCountriesVatBelowThreshold();

        FileOperations.WriteListToFile("src/com/engeto/projektSazbyDph/vat-over-" + inputRate + ".txt");
    }
}
