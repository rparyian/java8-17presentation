package com.example.java817presentation.optional;

import com.example.java817presentation.domain.User;
import com.example.java817presentation.exception.UserNotFoundException;

import java.util.Optional;

public class CheckOfValuePresence {
    class BadUsage {
        public String getUserName(Long userId) {
            Optional<User> user = findById(userId);
            if (user.isPresent()) {
                return user.get().getName();
            }
            throw new UserNotFoundException("User not found");
        }
    }

    class GoodUsage {
        public String getUserName(Long userId) {
            return findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("User not found"))
                    .getName();
        }
    }
    private Optional<User> findById(Long userId) {
        //search in DB
        return Optional.of(new User(1L, "Zlatan"));
    }
}
