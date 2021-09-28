package com.example.java817presentation.lambdas;

import com.example.java817presentation.domain.User;

import java.util.*;

public class Multimap {
    private final Map<String, Set<User>> usersByRole = new HashMap<>();

    class BadUsage {
        public void addUser(User user) {
            user.getRoles().forEach(r -> {
                Set<User> usersInRole = usersByRole.get(r.name());
                if (usersInRole == null) {
                    usersInRole = new HashSet<>();
                    usersByRole.put(r.name(), usersInRole);
                }
                usersInRole.add(user);
            });
        }

        public Set<User> getUsersInRole(String role) {
            Set<User> users = usersByRole.get(role);
            return users == null ? Collections.emptySet() : users;
        }
    }

    class GoodUsage {
        public void addUser(User user) {
            user.getRoles().forEach(r -> usersByRole
                    .computeIfAbsent(r.name(), k -> new HashSet<>())
                    .add(user));
        }

        public Set<User> getUsersInRole(String role) {
            return usersByRole.getOrDefault(role, Collections.emptySet());
        }
    }
}
