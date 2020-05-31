package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        String[] l1 = left.split("");
        String[] l2 = right.split("");
        Arrays.sort(l1);
        Arrays.sort(l2);
        return Arrays.equals(l1, l2);
    }
}
