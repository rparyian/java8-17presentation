package com.example.java817presentation.helpFullNpe;

import com.example.java817presentation.domain.User;

public class Npe {
    public static void main(String[] args) {
        var user = new User().setAge(25);
        var user1 = new User();
        User user2= null;
        int age=user.getAge();
        int age1=user1.getAge();
        int age2=user2.getAge();
    }
}
