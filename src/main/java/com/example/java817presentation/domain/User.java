package com.example.java817presentation.domain;

import com.example.java817presentation.defaulltAndStaticMethods.AnotherBlockable;
import com.example.java817presentation.defaulltAndStaticMethods.Blockable;
import com.example.java817presentation.defaulltAndStaticMethods.CountAgeInDays;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;
import java.util.Set;

@Data
@Accessors(chain = true)
public class User implements Blockable, AnotherBlockable, CountAgeInDays {
    private Long id;
    private String name;
    private int age;
    Optional<AutoBiography> autoBiography;
    Set<Role> roles;
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    @Override
    public void block() {
        System.out.println("I'm blocking");
    }

    @Override
    public void unblock() {
        System.out.println("I'm unblocking");
    }

    @Override
    public void blockFor10Days() {
        AnotherBlockable.super.blockFor10Days();
        Blockable.super.blockFor10Days();
    }

    public static void main(String[] args) {
        User user = new User(2l, "Vadim")
                .setAge(34);
        System.out.println(CountAgeInDays.getAgeInDays(user.getAge()));
        System.out.println(User.getAgeInDays(user.getAge()));
    }
    static int getAgeInDays(int age){
        return age*365+age/4;
    }
}
