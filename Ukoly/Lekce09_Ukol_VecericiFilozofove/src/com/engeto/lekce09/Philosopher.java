package com.engeto.lekce09;

public class Philosopher implements Runnable {
    private final Object leftFork;
    private final Object rightFork;
    private Integer portionsToEat;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.portionsToEat = 10000;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(1000);
        //Thread.sleep(((int) (Math.random() * 100)));
    }

    @Override
    public void run() {
        try {
            while (portionsToEat > 0) {
                // thinking
                doAction(": Thinking");
                synchronized (leftFork) {
                    doAction(": Picked up left fork");
                    synchronized (rightFork) {
                        // eating
                        doAction(": Picked up right fork - eating");
                        this.portionsToEat -= 2000;
                        System.out.println(Thread.currentThread().getName()
                                + " Portions left: " + this.portionsToEat);
                        doAction(": Put down right fork");
                    }
                    // Back to thinking
                    doAction(": Put down left fork");
                }
            }
            System.out.println(Thread.currentThread().getName()
                    + " Finished!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
