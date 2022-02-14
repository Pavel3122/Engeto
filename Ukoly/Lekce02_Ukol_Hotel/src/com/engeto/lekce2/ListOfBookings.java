package com.engeto.lekce2;

import java.util.ArrayList;

public class ListOfBookings {
    private static ArrayList <Booking> listOfBookings = new ArrayList<>();

    public static ArrayList<Booking> getListOfBookings() {
        return listOfBookings;
    }

    public static void AddToListOfBookings(Booking booking) {
        listOfBookings.add(booking);
    }

    public ListOfBookings() {

    }

    public static String getDescription () {
        String bookingsStr = "";

        for(Booking booking : listOfBookings){
            bookingsStr = bookingsStr + "Booking: " + booking.getDescription();
        }

        return bookingsStr;

    }

    public static void printAllBookings () {
        for (int i = 0; i < listOfBookings.size(); i++){
            System.out.println(listOfBookings.get(i).getDescription());
        }
    }
}
