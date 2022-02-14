package com.engeto.lekce2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Guest guest1 = new Guest("Adéla", "Malíková", new GregorianCalendar(1993, Calendar.MARCH, 3).getTime() );
        Guest guest2 = new Guest("Jan", "Dvořáček", new GregorianCalendar(1995, Calendar.MAY, 5).getTime() );
        System.out.println(guest1.getDescription());
        System.out.println(guest2.getDescription());

        Room room1 = new Room(1, 1, true, true, BigDecimal.valueOf(1000));
        Room room2 = new Room(2, 1, true, true, BigDecimal.valueOf(1000));
        Room room3 = new Room(3, 3, false, true, BigDecimal.valueOf(2400));

        Booking booking1 = new Booking(new GregorianCalendar(2021, Calendar.JULY, 19).getTime(),
                new GregorianCalendar(2021, Calendar.JULY, 26).getTime(),
                room1, TypeOfStay.recreational, new ArrayList<Guest>(){{add(guest1);}});

        Booking booking2 = new Booking(new GregorianCalendar(2021, Calendar.SEPTEMBER, 1).getTime(),
                new GregorianCalendar(2021, Calendar.SEPTEMBER, 14).getTime(),
                room3, TypeOfStay.recreational, new ArrayList<Guest>(){{add(guest1);add(guest2);}});

        Booking booking3 = new Booking(room3, TypeOfStay.recreational, new ArrayList<Guest>(){{add(guest1);add(guest2);}});

        ListOfBookings.printAllBookings();
    }
}
