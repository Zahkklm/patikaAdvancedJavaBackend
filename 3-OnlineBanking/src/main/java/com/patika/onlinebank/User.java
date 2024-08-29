package com.patika.onlinebank;

public class User {
    private String tc;
    private String password;
    private double balance;

    public User(String tc, String password, double balance) {
        this.tc = tc;
        this.password = password;
        this.balance = balance;
    }

    public String getTc() {
        return tc;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void transfer(User recipient, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance -= amount;
        recipient.setBalance(recipient.getBalance() + amount);
    }
}
