package ru.job4j.oop;

public class Animal {

    private String name;

    public Animal() {
        super();
        System.out.println("Animal");
    }

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal");
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger("Andrew");
    }
}
