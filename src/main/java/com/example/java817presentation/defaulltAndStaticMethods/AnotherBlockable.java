package com.example.java817presentation.defaulltAndStaticMethods;

public interface AnotherBlockable {
    default void blockFor10Days(){
        System.out.println("I'm blocking for 10 days with message");
    }
}
