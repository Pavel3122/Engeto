package com.engeto.projektSazbyDph;

import java.util.ArrayList;
import java.util.Collections;

public class Countries {
    private static int thresholdVatRate;
    private static ArrayList<Country> countryListAboveRate = new ArrayList<>();
    private static ArrayList<Country> countryListBelowRate = new ArrayList<>();

    public static int getThresholdVatRate() {
        return thresholdVatRate;
    }

    public static void setThresholdVatRate(int thresholdVatRate) {
        Countries.thresholdVatRate = thresholdVatRate;
    }

    public static ArrayList<Country> getCountryListAboveRate() {
        return countryListAboveRate;
    }

    public static void setCountryListAboveRate(ArrayList<Country> countryListAboveRate) {
        Countries.countryListAboveRate = countryListAboveRate;
    }

    public static ArrayList<Country> getCountryListBelowRate() {
        return countryListBelowRate;
    }

    public static void setCountryListBelowRate(ArrayList<Country> countryListBelowRate) {
        Countries.countryListBelowRate = countryListBelowRate;
    }

    public static void add(Country country) {
        if (country.getVatRateFull() > Countries.thresholdVatRate && !country.isSpecialVatRate()) {
            countryListAboveRate.add(country);
        } else {
            countryListBelowRate.add(country);
        }
    }

    public static void printAllCountries() {
        for (Country country : countryListAboveRate) {
            System.out.println(country.getName() + " (" + country.getNameAbbreviation() + "): " + String.format("%.0f", country.getVatRateFull()) + " % (" + String.format("%.0f", country.getVatRateDecreased()) + " %)" );
        }

        for (Country country : countryListBelowRate) {
            System.out.println(country.getName() + " (" + country.getNameAbbreviation() + "): " + String.format("%.0f", country.getVatRateFull()) + " %" );
        }
    }

    public static void printAllCountriesVatAboveThreshold() {
        for (Country country : countryListAboveRate) {
            System.out.println(country.toString());
        }
    }

    public static void printAllCountriesVatBelowThreshold() {
        String ctrStr = "";
        for (Country country : countryListBelowRate) {
            ctrStr += country.getNameAbbreviation() + ", ";
        }
        System.out.println("Sazba VAT " + Countries.getThresholdVatRate() + " % nebo nižší nebo používají speciální sazbu: " + ctrStr);
    }

    public static void sort(ArrayList<Country> list) {
        Collections.sort(list, Country.VatRateComparator);
    }
}
