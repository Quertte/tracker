package ru.job4j.tracker;


import javax.swing.*;
import java.util.Arrays;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("==== Create a new Item ====");
        String name = input.askStr("Введите имя:");
        tracker.add(new Item(name));
    }

    public static void all(Tracker tracker) {
        System.out.println("==== Show all items ====");
        Item[] items = tracker.findAll();
        if (items.length != 0) {
            for (Item it : items) {
                System.out.println(it.getName() + " - " + it.getId());
            }
        } else {
            System.out.println("Заявок нет");
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("==== Edit item ====");
        String id = input.askStr("Введите id заявки");
        String name = input.askStr("Введите имя новой заявки");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Заявка заменена");
        } else {
            System.out.println("Ошибка");
        }
    }

    public static void findByIdItem(Input input, Tracker tracker) {
        System.out.println("==== Find item by id ====");
        String id = input.askStr("Введите id заявки которую вы ищете");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.getName());
        } else {
            System.out.println("Такой заявки нет");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("==== Delete item ====");
        String id = input.askStr("Введите id заявки которую хотите удалить");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Заявки по такому id не существует");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("==== Find items by name ====");
        String name = input.askStr("Введите имя заявки");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item it : items) {
                System.out.println(it.getId() + " - " + it.getName());
            }
        } else {
            System.out.println("Таких заявок не существует");
        }
    }


    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.all(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findByIdItem(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input,tracker);
            } else if (select == 6) {
                System.out.println("Выход из программы");
                run = false;
            }
        }

    }

    private void showMenu() {
        System.out.println("Menu. ");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
