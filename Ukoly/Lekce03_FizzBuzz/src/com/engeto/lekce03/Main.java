package com.engeto.lekce03;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            String message = "";
            if (i % 3 == 0)
                message = "Fizz";
            if (i % 5 == 0)
                message += "Buzz";
            if (message.isEmpty())
                message = String.valueOf(i);

            System.out.println(message);
        }
    }
}
