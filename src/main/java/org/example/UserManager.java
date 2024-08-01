package org.example;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

class UserManager {
    private Map<Integer, String> users;
    private int nextId;

    public UserManager() {
        users = new HashMap<>();
        nextId = 1;
    }

    public int addUser(String name) {
        int id = nextId++;
        users.put(id, name);
        return id;
    }

    public String getUser(int id) {
        return users.getOrDefault(id, null);
    }

    public boolean deleteUser(int id) {
        if (users.containsKey(id)) {
            users.remove(id);
            return true;
        }
        return false;
    }

    public List<Integer> findUserByName(String name) {
        List<Integer> userIds = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : users.entrySet()) {
            if (entry.getValue().equals(name)) {
                userIds.add(entry.getKey());
            }
        }
        return userIds;
    }
}
