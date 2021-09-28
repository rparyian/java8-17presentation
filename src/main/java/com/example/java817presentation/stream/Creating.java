package com.example.java817presentation.stream;

import com.example.java817presentation.domain.Role;
import com.example.java817presentation.domain.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Creating {
    public Stream<Role> badUsageGetStreamFromList() {
        return Arrays.asList(Role.MODERATOR,Role.USER,Role.ADMIN).stream();
    }

    public Stream<Role> goodUsageGetStreamFromElements() {

        return Stream.of(Role.MODERATOR,Role.USER,Role.ADMIN);
    }

    public Stream<User> badUsageGenerateStreamByMappingCopies(int n) {
        return Collections.nCopies(n, null).stream()
                .map(s -> new User());
    }

    public Stream<User> badUsageGenerateStreamFromRange(int n) {
        return IntStream.range(0, n).mapToObj(i -> new User());
    }






    public Stream<User> goodUsageGenerateStreamFromSupplierWithLimit(int n) {
        return Stream.generate(User::new).limit(n);
    }




    public Stream<User> badUsageGenerateStreamFromArrayWithRange(User[] users, int max) {
        return IntStream.range(0, max).mapToObj(i -> users[i]);
    }









    public Stream<User> stillBadUsageGenerateStreamFromArrayWithRange(User[] users, int max) {
        int to = Integer.min(users.length, max);
        return IntStream.range(0, to).mapToObj(i -> users[i]);
    }







    public Stream<Role> generateStreamFromArrayWithLimit(Role[] roles, int max) {

        return Stream.of(roles).limit(max);
    }




    public static void main(String[] args) {
        new Creating().badUsageGenerateStreamByMappingCopies(5).forEach(System.out::println);
    }
}

