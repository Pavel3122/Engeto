package com.engeto.lekce06;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        Settings.tableCount = 5;

        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(new OrderItem("Caesar salát", BigDecimal.valueOf(150), 1));
        orderItems.add(new OrderItem("Big Burger", BigDecimal.valueOf(350), 1));
        orderItems.add(new OrderItem("Mattoni", BigDecimal.valueOf(30), 3));

	    Orders.add(new Order(
                1,
                1,
                LocalDate.of(2021,5, 20),
                FormOfPayment.BY_CASH,
                orderItems));

        System.out.println(Orders.getSoldItemsByTitle());

        System.out.println(Orders.getTotalTurnoversByDateOrdered());
    }
}
