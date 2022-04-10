package com.engeto.lekce06;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    int id;
    int tableNumber;
    LocalDate dateOrdered;
    FormOfPayment formOfPayment;
    ArrayList<OrderItem> items;

    public Order(int id, int tableNumber, LocalDate dateOrdered, FormOfPayment formOfPayment, ArrayList<OrderItem> items) throws Exception {
        if (tableNumber > Settings.tableCount)
            throw new Exception("Given Table Number is higher than current number of tables.");

        this.id = id;
        this.tableNumber = tableNumber;
        this.dateOrdered = dateOrdered;
        this.formOfPayment = formOfPayment;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) throws Exception {
        if (tableNumber > Settings.tableCount)
            throw new Exception("Given Table Number is higher than current number of tables.");
        this.tableNumber = tableNumber;
    }

    public LocalDate getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(LocalDate dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public FormOfPayment getFormOfPayment() {
        return formOfPayment;
    }

    public void setFormOfPayment(FormOfPayment formOfPayment) {
        this.formOfPayment = formOfPayment;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<OrderItem> items) {
        this.items = items;
    }
}
