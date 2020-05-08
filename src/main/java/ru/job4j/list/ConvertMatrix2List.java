package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6}
        };
        List<Integer> result = list.toList(array);
        System.out.println(result);
    }
}
