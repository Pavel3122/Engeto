package com.engeto.lekce06;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        // Set number of tables
        Settings.tableCount = 5;

        // Order 1
        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("Caesar salát", BigDecimal.valueOf(150), 2));
        orderItems.add(new OrderItem("Big Burger", BigDecimal.valueOf(350), 1));
        orderItems.add(new OrderItem("Mattoni", BigDecimal.valueOf(30), 3));

	    Orders.add(new Order(
                1,
                1,
                LocalDate.of(2021,5, 20),
                FormOfPayment.BY_CASH,
                orderItems));

        // Order 2
        orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("Big Burger", BigDecimal.valueOf(350), 2));
        orderItems.add(new OrderItem("Kofola velká", BigDecimal.valueOf(30), 2));

        Orders.add(new Order(
                2,
                5,
                LocalDate.of(2021,5, 18),
                FormOfPayment.BY_CARD,
                orderItems));

        // Order 3
        orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("Svíčková na smetaně", BigDecimal.valueOf(220), 1));
        orderItems.add(new OrderItem("Big Burger", BigDecimal.valueOf(350), 1));
        orderItems.add(new OrderItem("Smažený hermelín", BigDecimal.valueOf(135), 1));
        orderItems.add(new OrderItem("Palačinky s jahodami", BigDecimal.valueOf(160), 1));
        orderItems.add(new OrderItem("Mattoni", BigDecimal.valueOf(30), 2));
        orderItems.add(new OrderItem("Malinovka domácí", BigDecimal.valueOf(45), 2));
        Orders.add(new Order(
                3,
                1,
                LocalDate.of(2021,5, 20),
                FormOfPayment.BY_CARD,
                orderItems));

        // Order 4
        orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("Smažený hermelín", BigDecimal.valueOf(135), 3));
        orderItems.add(new OrderItem("Malinovka domácí", BigDecimal.valueOf(45), 3));
        Orders.add(new Order(
                4,
                2,
                LocalDate.of(2021,5, 18),
                FormOfPayment.BY_CARD,
                orderItems));

        // Task 3
        System.out.println(Orders.getSoldItemsByTitle());

        // Task 4
        System.out.println(Orders.getTotalTurnoversByDateOrdered());

        //Task 5
        System.out.println(Orders.getAllOrderedItemsTitles());

        // Task 6
        System.out.println(Orders.getOrderCountByTable());
    }
}
