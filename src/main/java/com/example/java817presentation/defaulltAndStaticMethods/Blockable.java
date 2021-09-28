package com.example.java817presentation.defaulltAndStaticMethods;

public interface Blockable {
    void block();
    void unblock();
    default void blockFor10Days(){
        System.out.println("I'm blocking for 10 days");
    }
}
