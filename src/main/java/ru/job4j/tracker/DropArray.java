package ru.job4j.tracker;

import java.util.Arrays;

public class DropArray {
    public static void main(String[] args) {
        String[] names = {"Petr", null, "Ivan", "Stepan", null};
        System.arraycopy(names, 2, names, 1, 2);
        System.out.println(Arrays.toString(names));


        String[] namesWithoutNull = new String[names.length];
        int size = 0;
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (name != null) {
                namesWithoutNull[size] = name;
                size++;
            }
        }
        namesWithoutNull = Arrays.copyOf(namesWithoutNull, size);
        for (int i = 0; i < namesWithoutNull.length; i++) {
            System.out.println(namesWithoutNull[i]);
        }
    }
}
