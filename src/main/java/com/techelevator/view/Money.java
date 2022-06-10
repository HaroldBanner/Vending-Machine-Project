package com.techelevator.view;

public class Money {

    public double balance;

    public Money(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double balance) {
        this.balance += balance;
    }

    public void subtractBalance(double price) {
        this.balance -= price;
    }

    public void returnChange(TransactionLogger log) {
        int numberOfCoins = (int) (balance * 100);
        int numberOfQuarters = numberOfCoins / 25;
        System.out.println("Quarters: " + numberOfQuarters);
        numberOfCoins = numberOfCoins - 25*numberOfQuarters;
        int numberOfDimes = numberOfCoins/10;
        System.out.println("Dimes: " + numberOfDimes);
        numberOfCoins = numberOfCoins - 10*numberOfDimes;
        int numberOfNickels = numberOfCoins/5;
        System.out.println("Nickels: " + numberOfNickels);
        log.log("Give Change:", balance, 0);
        balance = 0;

    }
}


