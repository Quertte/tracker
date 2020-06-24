package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        System.out.println(
                List.of(2, 1, 9, 2).stream().distinct().collect(Collectors.toMap(e -> e, e -> e * e))
        );

        List<Student> students = Arrays.asList(
                new Student(85, "Andreev"),
                new Student(100, "Vasilev"),
                new Student(65, "Petrov"),
                new Student(20, "Sidorov")
        );

        Map<String, Student> map = students.stream().distinct().collect(
                Collectors.toMap(Student::getSurname, student -> student));

        System.out.println(map);
    }
}
