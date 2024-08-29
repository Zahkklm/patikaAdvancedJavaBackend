package com.patika.onlinebank;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankServiceTest {

    @BeforeEach
    void setUp() {
        // Initialize test data if needed
    }

    private User UserService;


    @Test
    void testAddLoan() {
        boolean success = UserService.addLoan("12345678901", "loan2", 1000.0);
        assertTrue(success);
        User john = UserService.getUserByTc("12345678901");
        assertEquals(1000.0, john.getLoans().get(1).getAmount());
    }

    @Test
    void testAddCreditCardStatement() {
        boolean success = UserService.addCreditCardStatement("12345678901", "cc2", 200.0);
        assertTrue(success);
        User john = UserService.getUserByTc("12345678901");
        assertEquals(200.0, john.getCreditCardStatements().get(1).getAmount());
    }
}

