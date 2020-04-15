package ru.job4j.tracker;

public class FindNameActions implements UserAction {
    @Override
    public String name() {
        return "==== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item it : items) {
                System.out.println(it.getId() + " - " + it.getName());
            }
        } else {
            System.out.println("Таких заявок не существует");
        }
        return true;
    }
}
