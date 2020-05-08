package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rs1 = new ArrayList<>();
        for (int[] row : list) {
            for (int cell : row) {
                rs1.add(cell);
            }
        }
        return rs1;
    }
}
