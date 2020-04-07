package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book spartak = new Book("Spartak", 200);
        Book kolobok = new Book("kolobok", 20);
        Book redHat = new Book("redHat", 15);
        Book cleanCode = new Book("Clean Code", 500);

        Book[] books = new Book[4];
        books[0] = spartak;
        books[1] = kolobok;
        books[2] = redHat;
        books[3] = cleanCode;

        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getCountOfPages());
        }

        System.out.println("Переставляем Чистый код на место спартака");

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getCountOfPages());
        }

        System.out.println("Выводим только книги с названием Clean Code");

        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if (bk.getName().equals("Clean Code")) {
                System.out.println(bk.getName() + " - " + bk.getCountOfPages());
            }
        }
    }
}
