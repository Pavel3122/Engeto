package com.engeto.lekce05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class PlantList {
    private ArrayList<Plant> plantList;

    public ArrayList<Plant> getPlantList() {
        return plantList;
    }

    public void setPlantList(ArrayList<Plant> plantList) {
        this.plantList = plantList;
    }

    public PlantList() {
        this.plantList = new ArrayList<>();
    }

    public PlantList(ArrayList<Plant> plantList) {
        this.plantList = plantList;
    }

    public void Add(Plant plant) {
        this.plantList.add(plant);
    }

    public Plant GetByIndex(int index) {
        return this.plantList.get(index);
    }

    public Plant removeByIndex(int index) {
        return this.plantList.remove(index);
    }

    public void loadListFromFile(String filePath) throws PlantException {
        try(Scanner sc = new Scanner(new FileReader(filePath));){
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                String[] arr = line.split("\t");
                plantList.add(new Plant(arr[0], arr[1], LocalDate.parse(arr[4]), LocalDate.parse(arr[3]), Integer.parseInt(arr[2])));
            }
        } catch (FileNotFoundException e){
            throw new PlantException("Nenalezen vstupní soubor: " + e.getMessage());
        }
        catch (IOException e) {
            throw new PlantException("Chyba na vstupu při čtení ze vstupního souboru: " + e.getMessage());
        }
        catch (Exception e) {
            throw new PlantException("Neznámá chyba při čtení ze vstupního souboru: " + e.getMessage());
        }
    }

    public void writeListToFile(String filePath) throws PlantException {
        try {
            File fout = new File(filePath);
            FileOutputStream fos = new FileOutputStream(fout);
            OutputStreamWriter osw = new OutputStreamWriter(fos);

            for (Plant plant : plantList) {
                osw.write(plant.toString() + "\n");
            }

            osw.close();
        } catch (Exception e) {
            throw new PlantException(e.getMessage());
        }
    }
}
