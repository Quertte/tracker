package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        System.out.println(
                List.of(2, 1, 9, 2).stream().distinct().collect(Collectors.toMap(e -> e, e -> e * e))
        );

        List<Student> students = Arrays.asList(
                new Student(85, "Andreev"),
                new Student(100, "Vasilev"),
                new Student(65, "Petrov"),
                new Student(20, "Sidorov"),
                new Student(20, "Sidorov")
        );

        Map<String, Student> map = students.stream().collect(
                Collectors.toMap(Student::getSurname, student -> student,
                        (student1, student2) -> student1.getScore() > student2.getScore() ? student1 : student2));
        System.out.println(map);


        System.out.println(convertListik(List.of(List.of(1, 2), List.of(3, 4))));
        System.out.println(convert(new Integer[][]{{1, 2, 3}, {4, 5, 6}}));
    }


    public static List<Integer> convertListik(List<List<Integer>> matrix) {
        return matrix.stream().flatMap(List::stream).collect(Collectors.toList());
    }

    public static List<Integer> convert(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
