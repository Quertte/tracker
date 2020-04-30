package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    private static final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rs1 = new int[100];
        int size = 0;
        int x = money - price;
        for (int i = 0; i < COINS.length; i++) {
            while (x >= COINS[i]) {
                x = x - COINS[i];
                rs1[size++] = COINS[i];
            }
        }
        return Arrays.copyOf(rs1, size);
    }

    public static void main(String[] args) {
        Machine machine = new Machine();
        System.out.println(Arrays.toString(machine.change(50, 35)));
    }
}
