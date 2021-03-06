package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapason {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rs1 = new ArrayList<>();
        for (double i = start; i < end; i++) {
            rs1.add(func.apply(i));
        }
        return rs1;
    }
}
