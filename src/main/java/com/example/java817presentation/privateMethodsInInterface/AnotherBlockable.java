package com.example.java817presentation.privateMethodsInInterface;

public interface AnotherBlockable {
    default void blockFor10Days(){
        System.out.println("I'm blocking for 10 days with message: "+support());
    }
    private String support(){
        return "obscene language";
    }
}
