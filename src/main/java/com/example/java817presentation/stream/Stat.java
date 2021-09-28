package com.example.java817presentation.stream;

import com.example.java817presentation.domain.Role;
import com.example.java817presentation.domain.User;

import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.summarizingInt;

public class Stat {
    class BadUsage {
        public void printNameStats(List<User> users) {
            getNameLengthStream(users)
                    .max()
                    .ifPresent(max -> System.out.println("MAX: " + max));
            getNameLengthStream(users)
                    .min()
                    .ifPresent(min -> System.out.println("MIN: " + min));
        }

        private IntStream getNameLengthStream(List<User> users) {
            return users.stream()
                    .mapToInt(user -> user.getName().length());
        }
    }

    class GoodUsage {
        public void printNameStats(List<User> users) {
            IntSummaryStatistics statistics = users.stream()
                    .collect(summarizingInt(user -> user.getName().length()));
            System.out.println("MAX: " + statistics.getMax());
            System.out.println("MIN: " + statistics.getMin());
        }
    }










    public static void main(String[] args) {
        User user = new User(2l, "Vadim");
        user.setRoles(Set.of(Role.MODERATOR));
        User user1 = new User(2l,"Ignat");
        user1.setRoles(Set.of(Role.USER));
        List<User> users=List.of(user,user1);
        new Stat().new BadUsage().printNameStats(users);
        new Stat().new GoodUsage().printNameStats(Collections.emptyList());
    }
}
