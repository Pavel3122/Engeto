package com.engeto.lekce05;


import java.io.Serializable;
import java.time.LocalDate;

public class Plant {

    String Name;
    String  Notes;
    LocalDate planted;
    LocalDate watering;
    int frequencyOfWatering;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(int frequencyOfWatering) {
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequencyOfWatering) {
        if (frequencyOfWatering <= 0)
            new PlantException("Frequency of watering needs to higher than 0.");

        if (watering.compareTo(planted) < 0)
            new PlantException("Date of watering needs to be older than date of planting.");
        Name = name;
        Notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequencyOfWatering = frequencyOfWatering;
    }

    public Plant(String name, LocalDate planted, int frequencyOfWatering) {
        this(name, "", planted, LocalDate.now(), frequencyOfWatering);
    }

    public Plant(String name) {
        this(name, LocalDate.now(), 7);
    }

    public String getWateringInfo() {
        return String.format("%s, %s, %s",this.Name, this.watering.toString(), this.watering.plusDays(this.frequencyOfWatering).toString());
    }

    public String toString() {
        return this.Name + "\t" + this.Notes + "\t" +
                this.frequencyOfWatering + "\t" + this.watering.toString() + "\t" +
                this.planted.toString();
    }
}
