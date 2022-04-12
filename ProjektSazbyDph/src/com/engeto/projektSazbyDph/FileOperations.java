package com.engeto.projektSazbyDph;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class FileOperations {
    public static void LoadListFromFile(String filePath) {
        try(Scanner sc = new Scanner(new FileReader(filePath))){
            // French locale is used to parse commas as delimiter for decimal numbers
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] arr = line.split("\t");
                Countries.add(new Country(arr[0], arr[1], format.parse(arr[2]).doubleValue(),  format.parse(arr[3]).doubleValue(), Boolean.parseBoolean(arr[4])));
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void WriteListToFile(String filePath) {
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
