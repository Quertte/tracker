package ru.job4j.tracker;

public class AllItemsAction implements UserAction {
    @Override
    public String name() {
        return "==== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length != 0) {
            for (Item it : items) {
                System.out.println(it.getName() + ", " + it.getId());
            }
        } else {
            System.out.println("Заявок нет");
        }
        return true;
    }
}
