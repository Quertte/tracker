package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rs1 = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rs1.add(att);
            }
        }
        return rs1;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rs1 = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rs1.add(att);
            }
        }
        return rs1;
    }

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> pred) {
        List<Attachment> rs1 = new ArrayList<>();
        for (Attachment att : list) {
            if (pred.test(att)) {
                rs1.add(att);
            }
        }
        return rs1;
    }

    public static void main(String[] args) {
        List<Attachment> list = Arrays.asList(
                new Attachment("bugs", 150),
                new Attachment("fck", 110),
                new Attachment("Andrew", 90)
        );
        System.out.println(filter(list, x -> x.getSize() > 100));
        System.out.println(filter(list, x -> x.getName().contains("bug")));
    }


}
