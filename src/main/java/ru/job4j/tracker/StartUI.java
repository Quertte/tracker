package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("==== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("==== Show all items ====");
                if (tracker.findAll().length != 0) {
                    for (Item it : tracker.findAll()) {
                        System.out.println(it.getName() + " - " + it.getId());
                    }
                } else {
                    System.out.println("Заявок нет");
                }
            } else if (select == 2) {
                System.out.println("==== Edit item ====");
                System.out.println("Введите id заявки: ");
                String id = scanner.nextLine();
                System.out.println("Введите имя новой заявки");
                String name = scanner.nextLine();
                if (tracker.replace(id, new Item(name))) {
                    System.out.println("Заявка заменена");
                } else {
                    System.out.println("Ошибка");
                }
            } else if (select == 3) {
                System.out.println("==== Delete item ====");
                System.out.println("Введите id заявки которую хотите удалить: ");
                String id = scanner.nextLine();
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена");
                } else {
                    System.out.println("Заявки по такому id не существует");
                }
            } else if (select == 4) {
                System.out.println("==== Find item by id ====");
                System.out.println("Введите id заявки");
                String id = scanner.nextLine();
                System.out.println(tracker.findById(id).getName());
            }else if(select == 5){
                System.out.println("==== Find items by name ====");
                System.out.println("Введите имя заявки");
                String name = scanner.nextLine();
                for(Item it: tracker.findByName(name)){
                    System.out.println(it.getId() + " - " +  it.getName());
                }
            } else if (select == 6){
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
