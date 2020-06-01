package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] left1 = left.split("/");
        String[] right1 = right.split("/");
        int result = right1[0].compareTo(left1[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}
