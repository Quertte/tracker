package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] s1 = o1.split(". ");
        String[] s2 = o2.split(". ");
        return Integer.compare(Integer.parseInt(s1[0]), Integer.parseInt(s2[0]));
    }

    public static void main(String[] args) {
        String o1 = "10. ksdhgk";
        String[] s1 = o1.split(". ");
        System.out.println(Arrays.toString(s1));
        String n = Integer.toString(10);
        System.out.println(n);
    }
}
