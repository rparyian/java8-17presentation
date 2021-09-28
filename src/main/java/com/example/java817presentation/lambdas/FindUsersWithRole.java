package com.example.java817presentation.lambdas;

import com.example.java817presentation.domain.Role;
import com.example.java817presentation.domain.User;

import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toSet;

public class FindUsersWithRole {
    class BadUsage {
        public Set<User> findModerators(Set<User> users) {
               return   users.stream()
                    .filter(user -> user.getRoles().stream()
                               .anyMatch(Role.MODERATOR::equals))
                    .collect(toSet());
        }
    }







    class GoodUsage{
        public Set<User> findModerators(Set<User> users) {
            return users.stream()
                    .filter(isModerator())
                    .collect(toSet());
        }

        private Predicate<? super User> isModerator() {
            return user -> user.getRoles().stream()
                    .anyMatch(role->role.equals(Role.MODERATOR));
        }
    }

    public static void main(String[] args) {
        User user = new User(2l, "Vadim").
                setRoles(Set.of(Role.MODERATOR));
        User user1 = new User(2l,"Ignat").
                setRoles(Set.of(Role.USER));
        Set<User> users=Set.of(user,user1);
        System.out.println(new FindUsersWithRole().new GoodUsage().findModerators(users));
    }
}
