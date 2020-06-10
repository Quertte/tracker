package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
//        if (left.length() != right.length()) {
//            return false;
//        }
//        String[] l1 = left.split("");
//        String[] l2 = right.split("");
//        Arrays.sort(l1);
//        Arrays.sort(l2);
//        return Arrays.equals(l1, l2);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char b2 : left.toCharArray()) {
            map.putIfAbsent(b2, 1);
            map.computeIfPresent(b2, (key, value) -> value + 1);

//            if (map.containsKey(b2)) {
//                map.put(b2, map.get(b2) + 1);
//            } else {
//                map.put(b2, 1);
//            }
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char b1 : right.toCharArray()) {
            map1.putIfAbsent(b1, 1);
            map1.computeIfPresent(b1, (key, value) -> value + 1);
//            if (map1.containsKey(b1)) {
//                map1.put(b1, map1.get(b1) + 1);
//            } else {
//                map1.put(b1, 1);
//            }
        }
        return map.equals(map1);
    }

    public static void main(String[] args) {
        String x = "text";
        String y = "text";
        System.out.println(eq(x, y));
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < y.length(); i++) {
            char c = y.charAt(i);
            if (map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }
        System.out.println(map.equals(map1));
    }
}
