package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игра в 11");
        int number = 11;
        while (number > 0) {
            System.out.println("Игрок 1 тянет спички ");
            int select1 = Integer.valueOf(scanner.nextLine());
            if (select1 < 4 && select1 > 0) {
                number = number - select1;
                System.out.println("Спичек на столе осталось " + number);
                if (number <= 0) {
                    System.out.println("Игрок 1 победил");
                    break;
                }
            } else {
                System.out.println("Игрок должен взять от 1 до 3 спичек");
                System.out.println("Переход хода");
            }
            System.out.println("Игрок 2 тянет спички");
            int select2 = Integer.valueOf(scanner.nextLine());
            if (select2 < 4 && select2 > 0) {
                number = number - select2;
                System.out.println("Спичек на столе осталось " + number);
                if (number <= 0) {
                    System.out.println("Игрок 2 победил");
                    break;
                }
            } else {
                System.out.println("Игрок должен взять от 1 до 3 спичек");
                System.out.println("Переход хода");
            }
        }
    }
}
