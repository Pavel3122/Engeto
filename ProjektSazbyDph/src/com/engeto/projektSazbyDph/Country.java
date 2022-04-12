package com.engeto.projektSazbyDph;

import java.util.Comparator;

public class Country {
    private String Name;
    private String NameAbbreviation;
    private double vatRateFull;
    private double vatRateDecreased;
    private boolean specialVatRate;

    public Country(String nameAbbreviation, String name, double vatRateFull, double vatRateDecreased, boolean specialVatRate) {
        Name = name;
        NameAbbreviation = nameAbbreviation;
        this.vatRateFull = vatRateFull;
        this.vatRateDecreased = vatRateDecreased;
        this.specialVatRate = specialVatRate;
    }

    public static Comparator<Country> VatRateComparator = new Comparator<Country>() {

        public int compare(Country c1, Country c2) {
            Double countryRate1 = c1.getVatRateFull();
            Double countryRate2 = c2.getVatRateFull();

            //ascending order
            //return countryRate1.compareTo(countryRate2);

            //descending order
            return countryRate2.compareTo(countryRate1);
        }};

    @Override
    public String toString() {
        return this.getName() + " (" + this.getNameAbbreviation() + "): " + String.format("%.0f", this.getVatRateFull()) + " % (" + String.format("%.0f", this.getVatRateDecreased()) + " %)";
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNameAbbreviation() {
        return NameAbbreviation;
    }

    public void setNameAbbreviation(String nameAbbreviation) {
        NameAbbreviation = nameAbbreviation;
    }

    public double getVatRateFull() {
        return vatRateFull;
    }

    public void setVatRateFull(double vatRateFull) {
        this.vatRateFull = vatRateFull;
    }

    public double getVatRateDecreased() {
        return vatRateDecreased;
    }

    public void setVatRateDecreased(double vatRateDecreased) {
        this.vatRateDecreased = vatRateDecreased;
    }

    public boolean isSpecialVatRate() {
        return specialVatRate;
    }

    public void setSpecialVatRate(boolean specialVatRate) {
        this.specialVatRate = specialVatRate;
    }
}
