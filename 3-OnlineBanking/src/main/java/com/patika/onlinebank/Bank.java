package com.patika.onlinebank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getTc(), user);
    }

    public User getUser(String tc) {
        return users.get(tc);
    }

    public boolean authenticateUser(String tc, String password) {
        User user = getUser(tc);
        return user != null && user.authenticate(password);
    }

    public void processPayment(String tc, double amount) {
        User user = getUser(tc);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        user.setBalance(user.getBalance() - amount);
    }

    public void makeTransfer(String senderTc, String recipientTc, double amount) {
        User sender = getUser(senderTc);
        User recipient = getUser(recipientTc);
        if (sender == null || recipient == null) {
            throw new IllegalArgumentException("Sender or recipient not found");
        }
        sender.transfer(recipient, amount);
    }


    public void addUser(String s, User user) {
        addUser(user);
    }
}

