package ru.job4j.tracker;

public class ReplaceActions implements UserAction {
    @Override
    public String name() {
        return "==== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите id заявки: ");
        String name = input.askStr("Введите имя новой заявки: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Заявка заменена");
        } else {
            System.out.println("Ошибка");
        }
        return true;
    }
}
