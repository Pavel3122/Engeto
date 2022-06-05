package com.engeto.lekce09;

public class Philosopher implements Runnable {
    private final Object leftFork;
    private final Object rightFork;
    private Integer portionsToEat;
    private boolean lastPhilosopher;

    public Philosopher(Object leftFork, Object rightFork, boolean lastPhilosopher) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.lastPhilosopher = lastPhilosopher;
        portionsToEat = 10000;
    }

    public Philosopher(Object leftFork, Object rightFork) {
        this(leftFork, rightFork, false);
    }

    private void printAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " : " + action);
    }

    @Override
    public void run() {
        try {
            while (portionsToEat > 0) {
                // thinking
                printAction("Thinking");
                if(lastPhilosopher) {
                    // Deadlock protection - opposite use of forks by last philosopher
                    synchronized (rightFork) {
                        printAction("Picked up right fork");
                        synchronized (leftFork) {
                            // eating
                            printAction("Picked up left fork - eating");
                            portionsToEat -= 1;
                            System.out.println(Thread.currentThread().getName()
                                    + " Portions left: " + portionsToEat);
                            printAction("Put down left fork");
                        }
                        // Back to thinking
                        printAction("Put down right fork");
                    }
                } else {
                    synchronized (leftFork) {
                        printAction("Picked up left fork");
                        synchronized (rightFork) {
                            // eating
                            printAction("Picked up right fork - eating");
                            portionsToEat -= 1;
                            System.out.println(Thread.currentThread().getName()
                                    + " Portions left: " + portionsToEat);
                            printAction("Put down right fork");
                        }
                        // Back to thinking
                        printAction("Put down left fork");
                    }
                }
            }
            System.out.println(Thread.currentThread().getName()
                    + " Finished!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
