package com.company;

public class Main {

    public static void main(String[] args) {

        CheckingAccount account = new CheckingAccount(100);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();

                for (int i = 0; i < 10; i++) {
                    //this is the synchronized statement that allows one thread to access the
                    //checking account at a time
                    synchronized (account) {
                        System.out.println(name + " tries to withdraw $10, balance: " +
                                account.withdraw(10));
                    }

                }
            }
        };

        Thread thdHusband = new Thread(r);
        thdHusband.setName("Husband");

        Thread thdWife = new Thread(r);
        thdWife.setName("Wife");

        thdHusband.start();
        thdWife.start();

    }
}
