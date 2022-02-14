package com.engeto.lekce2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Booking {
    private Date reservationStart;
    private Date reservationEnd;
    private Room room;
    private TypeOfStay typeOfStay;
    private ArrayList <Guest> guests;

    public Date getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(Date reservationStart) {
        this.reservationStart = reservationStart;
    }

    public Date getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(Date reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public TypeOfStay getTypeOfStay() {
        return typeOfStay;
    }

    public void setTypeOfStay(TypeOfStay typeOfStay) {
        this.typeOfStay = typeOfStay;
    }

    public Booking(Date reservationStart, Date reservationEnd,
                   Room room, TypeOfStay typeOfStay,
                   ArrayList<Guest> guests) {

        if (reservationStart == null && reservationEnd == null){
            reservationStart = Calendar.getInstance().getTime();  // today

            Calendar c = Calendar.getInstance();
            c.setTime(reservationStart);
            c.add(Calendar.DATE, 6);  // today + 6 days
            reservationEnd = c.getTime();
        }

        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.room = room;
        this.typeOfStay = typeOfStay;
        this.guests = guests;

        ListOfBookings.AddToListOfBookings(this);
    }

    public Booking(Room room, TypeOfStay typeOfStay, ArrayList<Guest> guests) {
        // Booking without specified dates
        this(null, null, room, typeOfStay, guests);
    }

    public String getDescription () {
        String guestsStr = "";
        for (Guest guest : guests){
            guestsStr = guestsStr + guest.getFirstName() + " " + guest.getLastName() + ";";
        }

        return "Reservation Start: " + this.reservationStart +
                ", Reservation End: " + this.reservationEnd +
                ", Room : " + this.room.getDescription() +
                ", Type of Stay: " + this.typeOfStay.toString() +
                ", Guests: " + guestsStr;
    }
}
