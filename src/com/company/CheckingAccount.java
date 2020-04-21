package com.company;

import java.util.*;

public class CheckingAccount {

    private int balance;

    public CheckingAccount(int initialBalance) {
        balance = initialBalance;
    }

     public int withdraw(int amount) {

        if (amount <= balance){
            try {
                Thread.sleep((int) (Math.random() * 200));
            }
            catch (InterruptedException ie) {
            }

            balance -= amount;
        }
        return balance;
    }

}
