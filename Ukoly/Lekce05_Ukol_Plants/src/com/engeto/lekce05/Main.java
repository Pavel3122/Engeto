package com.engeto.lekce05;

public class Main {

    public static void main(String[] args) {
        PlantList plantList1 = new PlantList();
        plantList1.LoadListFromFile("src/com/engeto/lekce05/kvetiny.txt");

        plantList1.getPlantList().forEach((n) -> System.out.println(n.getWateringInfo()));

        plantList1.getPlantList().add(new Plant("Plant 1"));
        plantList1.getPlantList().add(new Plant("Plant 2"));

        plantList1.RemoveByIndex(0);

        plantList1.WriteListToFile("src/com/engeto/lekce05/kvetiny_out.txt");
        System.out.println(plantList1.getPlantList().size());

        PlantList plantList2 = new PlantList();
        plantList2.LoadListFromFile("src/com/engeto/lekce05/kvetiny_out.txt");
        System.out.println(plantList2.getPlantList().size());

        //plantList1.LoadListFromFile("src/com/engeto/lekce05/kvetiny-spatne-datum.txt");

        //plantList1.LoadListFromFile("src/com/engeto/lekce05/kvetiny-spatne-frekvence.txt");
    }
}
