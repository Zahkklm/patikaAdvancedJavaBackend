package com.patika.onlinebank;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, User> readUsersFromFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<Map<String, User>>() {});
    }

    public static void writeUsersToFile(Map<String, User> users, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), users);
    }
}
