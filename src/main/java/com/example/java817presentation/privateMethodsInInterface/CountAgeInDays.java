package com.example.java817presentation.privateMethodsInInterface;

public interface CountAgeInDays {
    static int getAgeInDays(int age){
        return age*365+support(age);
    }
    private static int support(int age){
        return age/4;
    }
}
