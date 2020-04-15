package ru.job4j.tracker;

public class DeleteActions implements UserAction {
    @Override
    public String name() {
        return "==== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Введите id заявки которую хотите удалить: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Заявки по такому id не существует");
        }
        return true;
    }
}
