package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int result;
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            result = Character.compare(o1.charAt(i), o2.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(o1.length(), o2.length());
//        int rs1 = Integer.compare(o1.length(), o2.length());
//        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
//            if (o1.charAt(i) != o2.charAt(i)) {
//                rs1 = Integer.compare(o1.charAt(i), o2.charAt(i));
//                break;
//            }
//        }
//        return rs1;
    }

    public static void main(String[] args) {
        String petr = "Petrov";
        String ivan = "Patrov";
        int rslStr = petr.compareTo(ivan);
        System.out.println(rslStr);
        String[] s1 = petr.split("");
        System.out.println(Arrays.toString(s1));
    }
}
