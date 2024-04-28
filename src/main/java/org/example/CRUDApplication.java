package org.example;

import java.util.HashMap;
import java.util.Map;

public class CRUDApplication {
    private Map<String, String> data;

    public CRUDApplication() {
        this.data = new HashMap<>();
    }

    public void create(String key, String value) {
        data.put(key, value);
    }

    public String read(String key) {
        return data.get(key);
    }

    public void update(String key, String value) {
        if (data.containsKey(key)) {
            data.put(key, value);
        } else {
            System.out.println("Key not found");
        }
    }

    public void delete(String key) {
        if (data.containsKey(key)) {
            data.remove(key);
        } else {
            System.out.println("Key not found");
        }
    }
}
