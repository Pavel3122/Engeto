package com.engeto.lekce06;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Orders {
    private static ArrayList<Order> orders = new ArrayList<>();

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static void setOrders(ArrayList<Order> orders) {
        Orders.orders = orders;
    }

    public static long getOrdersCount() {
        return orders.stream().count();
    }

    public static void add(Order order) {
        orders.add(order);
    }

    public static BigDecimal getOrdersTotalPrice () {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Order order : orders) {
            for (OrderItem item : order.getItems()) {
                totalPrice = totalPrice.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            }
        }
        return totalPrice;
    }

    public static String getSoldItemsByTitle () {
        HashMap<String, Integer> Items = new HashMap<>();
        
        for (Order order : orders) {
            for (OrderItem item : order.getItems()) {
                if (Items.containsKey(item.getTitle())) {
                    // Increment already existing record in Items HashMap
                    Items.put(item.getTitle(), Items.get(item.getTitle())+item.getQuantity());
                } else {
                    // Add new Item to Items HashMap
                    Items.put(item.getTitle(), (item.getQuantity()));
                }
            }
        }

        // Print Items to string
        String message = "";
        for (String itemTitle: Items.keySet()) {
            message += itemTitle.toString() + "=" + Items.get(itemTitle).toString() + ",";
        }

        return message;
    }

    public static String getTotalTurnoversByDateOrdered () {
        HashMap<LocalDate, BigDecimal> Turnovers = new HashMap<>();
        
        for (Order order : orders) {
            BigDecimal turnover = BigDecimal.ZERO;
            
            for (OrderItem item : order.getItems()) {
                // Multiply quantity and price of the order item
                turnover = turnover.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            }

            if (Turnovers.containsKey(order.getDateOrdered())) {
                // Increment already existing record in Turnovers HashMap
                Turnovers.put(order.getDateOrdered(), Turnovers.get(order.getDateOrdered()).add(turnover));
            } else {
                // Add new Date to Turnovers HashMap
                Turnovers.put(order.getDateOrdered(), turnover);
            }
        }

        // Print Turnovers to string
        String message = "";
        for (LocalDate dateOrdered: Turnovers.keySet()) {
            message += dateOrdered.toString() + "=" + Turnovers.get(dateOrdered).toString() + ",";
        }

        return message;
    }

    public static String getAllOrderedItemsTitles() {
        ArrayList<String> itemTitles = new ArrayList<>();

        HashMap<LocalDate, BigDecimal> Turnovers = new HashMap<>();

        for (Order order : orders) {
            for (OrderItem item : order.getItems()) {
                if (!itemTitles.contains(item.getTitle())) {
                    itemTitles.add(item.getTitle());
                }
            }
        }

        itemTitles.sort(String::compareToIgnoreCase);

        // Print Titles to string
        String message = "";
        for (String itemTitle: itemTitles) {
            message += itemTitle + ",";
        }

        return message;
    }

    public static String getOrderCountByTable () {
        HashMap<Integer, Integer> tableOrders = new HashMap<>();

        for (Order order : orders) {
            if (tableOrders.containsKey(order.getTableNumber())) {
                // Increment already existing table in tableOrders HashMap
                tableOrders.put(order.getTableNumber(), tableOrders.get(order.getTableNumber()) + 1);
            } else {
                // Add new table to tableOrders HashMap
                tableOrders.put(order.getTableNumber(), 1);
            }
        }

        // Print table orders to string
        String message = "Počet objednávek u stolů: ";
        for (int tableNumber: tableOrders.keySet()) {
            message += "stůl č." + tableNumber + ":" + tableOrders.get(tableNumber).toString() + ",";
        }

        return message;
    }
}
