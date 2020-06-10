package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;

public class ZonaVidimostiVLambda {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Petr", "Ivan", "Nick");
        final StringBuilder last = new StringBuilder();
        names.forEach(n -> {
            last.ensureCapacity(0);
            last.append(n);
        });

        System.out.println(last);
    }
}
