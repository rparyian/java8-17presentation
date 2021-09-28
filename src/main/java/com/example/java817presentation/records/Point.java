package com.example.java817presentation.records;

public record Point(float x, float y) {
    public static void main(String[] args) {
        System.out.println(new Point(3f,5f));
    }
}
