package com.example.java817presentation.stream;

import com.example.java817presentation.domain.User;

import java.util.List;

import static java.util.Comparator.comparingInt;

public class FindingBy {
    class BadUsage {
        public User findUsersWithMostRoles(List<User> users) {
            if (users.isEmpty()) {
                return null;
            }
            User findUser = users.iterator().next();
            for (User user : users) {
                if (user.getRoles().size() > findUser.getRoles().size()) {
                    findUser = user;
                }
            }
            return findUser;
        }
    }

    class StillBadUsage {
        public User findUsersWithMostRoles(List<User> users) {
            return users.stream()
                    .sorted(comparingInt(u -> u.getRoles().size()))
                    .findFirst()
                    .orElse(null);
        }
    }







    class ExcellentUsage {
        public User findUsersWithMostRoles(List<User> users) {
            return users.stream()
                    .max(comparingInt(u -> u.getRoles().size()))
                    .orElse(null);
        }
    }
}
