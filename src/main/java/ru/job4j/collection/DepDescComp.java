package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String left1 = left.substring(0, 2);
        String right1 = right.substring(0, 2);
        int rsl = right1.compareTo(left1);
        if (rsl == 0) {
            if (left.length() > 3 && right.length() > 3) {
                String left2 = left.substring(3);
                String right2 = right.substring(3);
                rsl = left2.compareTo(right2);
            } else {
                rsl = left.length() - right.length();
            }
        }
        return rsl;
    }
}
