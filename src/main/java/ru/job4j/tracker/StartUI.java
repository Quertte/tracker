package ru.job4j.tracker;


import java.util.List;

public class StartUI {

    /*public static void createItem(Input input, Tracker tracker) {
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
    }*/

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }

    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        int i = 0;
        for (UserAction action : actions) {
            System.out.println((i++) + ")" + action.name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new CreateAction(), new FindAllAction(),
                new ReplaceActions(), new DeleteActions(),
                new FindIdActions(), new FindByNameAction(), new ExitActions());

        new StartUI().init(validate, tracker, actions);
    }
}
