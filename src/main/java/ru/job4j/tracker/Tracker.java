package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки
     */
    private int position = 0;

    /**
     * Метод добавления заявки в хранилище
     */
    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * ТК у заявки нет уникальности полей, имени описания. Для идентификации нужен уникальный ключ.
     *
     * @return Уникальный ключ
     */

    private String generateId() {
        // Реализовать метод генерации
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, position);
    }

    public Item[] findByName(String key) {
        Item[] fndName = new Item[position];
        int size = 0;
        for (int i = 0; i < position; i++) {
            Item it = this.items[i];
            if (it.getName().equals(key)) {
                fndName[size++] = it;
            }
        }
        fndName = Arrays.copyOf(fndName, size);
        return fndName;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public void replace(String id, Item item) {
        int index = this.indexOf(id);
        item.setId(id);
        this.items[index] = item;
    }

    private int indexOf(String id) {
        int rs = -1;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                rs = i;
                break;
            }
        }
        return rs;
    }
}
