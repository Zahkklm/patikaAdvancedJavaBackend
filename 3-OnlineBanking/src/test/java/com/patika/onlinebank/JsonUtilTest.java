package com.patika.onlinebank;


import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtilTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String JSON_FILE_PATH = "src/test/resources/users.json";

    @BeforeEach
    void setUp() {
        // Any setup code if needed
    }

    @Test
    void testReadUsersFromJson() throws IOException {
        List<User> users = OBJECT_MAPPER.readValue(new File(JSON_FILE_PATH), new TypeReference<List<User>>() {});
        assertNotNull(users);
        assertTrue(users.size() > 0, "Users list should not be empty.");
        assertEquals("John Doe", users.get(0).getName(), "The name of the first user should be 'John Doe'.");
    }

    @Test
    void testWriteUsersToJson() throws IOException {
        List<User> users = List.of(
                new User("12345678901", "securePassword1", "John Doe", 1000.0),
                new User("10987654321", "securePassword2", "Jane Smith", 500.0)
        );

        OBJECT_MAPPER.writeValue(new File(JSON_FILE_PATH), users);

        // Read the file back to check if the data was correctly written
        List<User> readUsers = OBJECT_MAPPER.readValue(new File(JSON_FILE_PATH), new TypeReference<List<User>>() {});
        assertEquals(users.size(), readUsers.size(), "The number of users should match.");
        assertEquals(users.get(0).getName(), readUsers.get(0).getName(), "The name of the first user should match.");
    }

    @Test
    void testUserSerialization() throws IOException {
        User user = new User("12345678901", "securePassword1", "John Doe", 1000.0);
        String jsonString = OBJECT_MAPPER.writeValueAsString(user);
        assertNotNull(jsonString);
        assertTrue(jsonString.contains("John Doe"), "JSON string should contain the user's name.");
    }

    @Test
    void testUserDeserialization() throws IOException {
        String jsonString = "{ \"tc\": \"12345678901\", \"password\": \"securePassword1\", \"name\": \"John Doe\", \"balance\": 1000.0 }";
        User user = OBJECT_MAPPER.readValue(jsonString, User.class);
        assertNotNull(user);
        assertEquals("John Doe", user.getName(), "The name should be 'John Doe'.");
        assertEquals(1000.0, user.getBalance(), "The balance should be 1000.0.");
    }
}

