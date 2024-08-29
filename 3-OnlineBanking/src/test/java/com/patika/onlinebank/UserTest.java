package com.patika.onlinebank;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class UserTest {

    private User user;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @BeforeEach
    void setUp() throws IOException {
        user = OBJECT_MAPPER.readValue(new File("src/test/resources/users.json"), User.class);
    }

    @Test
    void testUserLogin() {
        assertTrue(UserService.login("12345678901", "securePassword1"));
        assertFalse(UserService.login("12345678901", "wrongPassword"));
        assertFalse(UserService.login("00000000000", "securePassword1"));
    }

    @Test
    void testTransferFunds() {
        User john = UserService.getUserByTc("12345678901");
        User jane = UserService.getUserByTc("10987654321");

        boolean success = UserService.transferFunds("12345678901", "10987654321", 200.0);
        assertTrue(success);
        assertEquals(800.0, john.getBalance());
        assertEquals(700.0, jane.getBalance());
    }

    @Test
    void testMakePayment() {
        User john = UserService.getUserByTc("12345678901");
        boolean success = UserService.makePayment("12345678901", "loan1", 100.0);
        assertTrue(success);
        assertEquals(100.0, john.getLoans().get(0).getPaid());
    }
}

