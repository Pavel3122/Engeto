package com.engeto.lekce2;

import java.math.BigDecimal;

public class Room {
    private int roomNumber;
    private int numberOfBeds;
    private boolean hasBalcony;
    private boolean hasOceanView;
    private BigDecimal pricePerNight;

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isHasOceanView() {
        return hasOceanView;
    }

    public void setHasOceanView(boolean hasOcenView) {
        this.hasOceanView = hasOcenView;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Room(int roomNumber, int numberOfBeds, boolean hasBalcony, boolean hasOceanView, BigDecimal pricePerNight) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.hasBalcony = hasBalcony;
        this.hasOceanView = hasOceanView;
        this.pricePerNight = pricePerNight;
    }

    public String getDescription () {
        return "Room Number: " + this.roomNumber +
                ", Number of Beds: " + this.numberOfBeds +
                ", Has Balcony: " + this.hasBalcony +
                ", Has Ocean View: " + this.hasOceanView +
                ", Price per Night: " + this.pricePerNight.toString();
    }
}
