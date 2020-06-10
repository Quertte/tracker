package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> predicate = attachment -> attachment.getSize() > 100;
//        Predicate predicate = new Predicate() {
//            @Override
//            public boolean test(Object o) {
//                Attachment att = (Attachment) o;
//                return att.getSize() > 100;
//            }
//        };
        return filter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
//        Predicate<Attachment> predicate = new Predicate<Attachment>() {
//            @Override
//            public boolean test(Attachment attachment) {
//                return attachment.getName().contains("bug");
//            }
//        };
        return filter(list, attachment -> attachment.getName().contains("fc"));
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
        System.out.println(filterName(list));
        System.out.println(filterSize(list));
//        System.out.println(filter(list, x -> x.getSize() > 100));
//        System.out.println(filter(list, x -> x.getName().contains("bug")));
    }


}
