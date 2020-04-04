package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    private static int number = 11;
    private static int count;
    private static String act;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра в 11");
        while (number > 0) {
            act = count % 2 == 0 ? "Первый" : "Второй";
            System.out.println("Ходит " + act + " игрок.\nОсталось: " + number + " спичек из 11");
            int select = Integer.valueOf(scanner.nextLine());
            count++;
            boolean run = true;
            while (run) {
                if (check(select)) {
                    number -= select;
                    System.out.println("На столе осталось спичек " + number);
                    run = false;
                    if (number <= 0) {
                        System.out.println("Победил " + act + " игрок");
                        break;
                    }
                } else {
                    System.out.println("Игрок " + act + " должен взять от 1 до 3 спичек");
                    select = Integer.valueOf(scanner.nextLine());
                }
            }
        }
    }

    public static boolean check(int select) {
        boolean result = false;
        if (select < 4 && select > 0) {
            result = true;
        }
        return result;
    }
}
