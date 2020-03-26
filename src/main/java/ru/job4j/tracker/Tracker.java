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
    public Item add(Item item){
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * ТК у заявки нет уникальности полей, имени описания. Для идентификации нужен уникальный ключ.
     * @return Уникальный ключ
     */

    private String generateId(){
        // Реализовать метод генерации
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item[] findAll(){
        Item[] nameWithOutNull = new Item[this.items.length];
        int size = 0;
        for(int i = 0; i < position; i ++ ){
            Item it = this.items[i];
            if(it != null){
                nameWithOutNull[size] = it;
                size++;
            }
        }
        nameWithOutNull = Arrays.copyOf(nameWithOutNull,size);
        return nameWithOutNull;
    }

    public Item[] findByName(String key){
        Item[] fndName = new Item[this.items.length];
        int size = 0;
        for(int i = 0; i < position; i++){
            Item it = this.items[i];
            if(it.getName().equals(key)){
                fndName[size] = it;
                size ++;
            }
        }
        fndName = Arrays.copyOf(fndName,size);
        return fndName;
    }

    public Item findById(String id){
        Item it = null;
        for(int i = 0; i < position; i++){
            it = this.items[i];
            if(it.getId().equals(id))
            break;
        }
        return it;
    }
}
