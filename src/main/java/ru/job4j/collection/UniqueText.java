package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rs1 = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split((" "));
        HashSet<String> check = new HashSet<>();
        for (String orig : origin) {
            check.add(orig);
        }

        for (String tex : text) {
            if (!check.contains(tex)) {
                rs1 = false;
                break;
            }
        }
        return rs1;
    }
}
