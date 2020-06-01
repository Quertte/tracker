package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new HashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (start.length() > 0) {
                    start += "/";
                }
                start += el;
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Petr");
        set.add("Ivan");
        System.out.println(set);

        List<String> input = Arrays.asList("K1/SK1/SSK1", "K2/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2", "K1/SK1", "K2/SK1/SSK2");
        List<String> list = fillGaps(input);
        String s500 = "K1/SK1/SSK1";
        System.out.println(s500.substring(3));
        System.out.println(list);
        sortAsc(list);
        System.out.println(list);
        sortDesc(list);
        System.out.println(list);
    }
}
