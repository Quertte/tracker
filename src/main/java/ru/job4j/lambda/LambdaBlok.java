package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaBlok {
    public static void main(String[] args) {
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + left + " : " + right);
            return right.compareTo(left);
        };

        String[] strings = {"Ivanov", "Petrov", "Sidorov"};

        Arrays.sort(strings, comparator);
        System.out.println(Arrays.toString(strings));
    }
}
