package com.example.java817presentation.functionalInterface;

@FunctionalInterface
public interface OctaOperator <T>{
    T apply(T t1, T t2, T t3, T t4, T t5, T t6);
    default void getName(){
        System.out.println(OctaOperator.class.getName());
    }
    String toString();
}
