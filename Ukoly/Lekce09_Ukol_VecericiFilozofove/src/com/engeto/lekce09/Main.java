package com.engeto.lekce09;

public class Main {

    public static void main(String[] args) {
        // Prepare philosophers and forks
        int philospohersAndForksCount = 10;

        Object[] forks = new Object[philospohersAndForksCount];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philospohersAndForksCount; i++) {
            Philosopher philosopher;
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            if (i == philospohersAndForksCount - 1) {
                // Deadlock protection - The last philosopher property
                philosopher = new Philosopher(leftFork, rightFork, true);
            } else {
                philosopher = new Philosopher(leftFork, rightFork);
            }

            // Philosopher starts
            Thread t
                    = new Thread(philosopher, "Philosopher " + (i + 1));
            t.start();
        }
    }
}
