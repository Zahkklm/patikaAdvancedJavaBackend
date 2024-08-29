package com.patika.onlinebank;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        String filePath = "src/main/resources/users.json";

        try {
            Map<String, User> users = JsonUtil.readUsersFromFile(filePath);
            users.forEach(bank::addUser);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Test User Operations
        User user1 = bank.getUser("12345678901");
        User user2 = bank.getUser("10987654321");

        if (user1 != null && user2 != null) {
            try {
                bank.makeTransfer("12345678901", "10987654321", 100);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            bank.processPayment("12345678901", 50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Map<String, User> updatedUsers = Map.of(
                    user1.getTc(), user1,
                    user2.getTc(), user2
            );
            JsonUtil.writeUsersToFile(updatedUsers, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
