package com.engeto.projektSazbyDph;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class FileOperations {
    public static void loadListFromFile(String filePath) throws CountryException {
        try(Scanner sc = new Scanner(new FileReader(filePath))){
            // French locale is used to parse commas as delimiter for decimal numbers
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] arr = line.split("\t");
                Countries.add(new Country(arr[0], arr[1], format.parse(arr[2]).doubleValue(),  format.parse(arr[3]).doubleValue(), Boolean.parseBoolean(arr[4])));
            }
        } catch (IOException e) {
            throw new CountryException("Chyba vstupu při čtení seznamu zemí: " + e.getMessage());
        } catch (ParseException e) {
            throw new CountryException("Chyba parsování při čtení seznamu zemí: " + e.getMessage());
        } catch (Exception e) {
            throw new CountryException("Neočekávaná chyba při čtení seznamu zemí: " + e.getMessage());
        }
    }

    public static void writeListToFile(String filePath) throws CountryException {
        try {
            File fout = new File(filePath);
            FileOutputStream fos = new FileOutputStream(fout);
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            for (Country country : Countries.getCountryListAboveRate()) {
                osw.write(country.toString() + "\n");
            }

            osw.write("====================" + "\n");

            for (Country country : Countries.getCountryListBelowRate()) {
                osw.write(country.toString() + "\n");
            }

            osw.close();
        } catch (IOException e) {
            throw new CountryException("Chyba vstupu při zápisu seznamu zemí: " + e.getMessage());
        } catch (Exception e) {
            throw new CountryException("Neočekávaná chyba při zápisu seznamu zemí: " + e.getMessage());
        }
    }
}
