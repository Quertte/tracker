package ru.job4j.tracker;

public class FindIdActions implements UserAction {
    @Override
    public String name() {
        return "==== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите id заявки которую вы ищете: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.getName());
        } else {
            System.out.println("Такой заявки нет");
        }
        return true;
    }
}
