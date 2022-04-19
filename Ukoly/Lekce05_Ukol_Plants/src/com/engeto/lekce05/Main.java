package com.engeto.lekce05;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws PlantException {
        PlantList plantList1 = new PlantList();
        try {
            plantList1.loadListFromFile("src/com/engeto/lekce05/kvetiny.txt");
        } catch (PlantException e) {
            System.out.println(e.getMessage());
        }

        plantList1.getPlantList().forEach((n) -> System.out.println(n.getWateringInfo()));

        plantList1.getPlantList().add(new Plant("Plant 1"));
        plantList1.getPlantList().add(new Plant("Plant 2"));

        plantList1.removeByIndex(0);

        try {
            plantList1.writeListToFile("src/com/engeto/lekce05/kvetiny_out.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(plantList1.getPlantList().size());

        PlantList plantList2 = new PlantList();

        try {
            plantList2.loadListFromFile("src/com/engeto/lekce05/kvetiny_out.txt");
        } catch (PlantException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(plantList2.getPlantList().size());

        try {
            plantList1.loadListFromFile("src/com/engeto/lekce05/kvetiny-spatne-datum.txt");
        } catch (PlantException e) {
            System.out.println(e.getMessage());
        }

        try {
            plantList1.loadListFromFile("src/com/engeto/lekce05/kvetiny-spatne-frekvence.txt");
        } catch (PlantException e) {
            System.out.println(e.getMessage());
        }
    }
}
