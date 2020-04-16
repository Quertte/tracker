package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "==== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length != 0) {
            for (Item it : items) {
                System.out.println(it.getId() + " " + it.getName());
            }
        } else {
            System.out.println("Заявок нет");
        }
        return true;
    }
}
