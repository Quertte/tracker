package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод добавления заявки в хранилище
     */
    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
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

    public List<Item> findAll() {
        return this.items;
    }

    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(key)) {
                list.add(item);
            }
        }
        return list;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean rs1 = index != -1;
        if (rs1) {
            item.setId(id);
            this.items.set(index, item);
        }
        return rs1;
    }

    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rs1 = index != -1;
        if (rs1) {
            this.items.remove(index);
        }
        return rs1;
    }

    private int indexOf(String id) {
        int rs = -1;
        for (Item item : this.items) {
            if (item.getId().equals(id)) {
                rs = this.items.indexOf(item);
            }
        }
        return rs;
    }
}
