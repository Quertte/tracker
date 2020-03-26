package ru.job4j.pojo;

public class Shop {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        products[3] = new Product("Pasta", 1);
        products[4] = new Product("Oil", 2);

        shop.delete(products, 5);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            // Проверяем, что объект не равен null. тк у нас массив не заполнен, целиком
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.println("Удаляем значение из ячейки с индексом 1");

        products[1] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

        System.out.println();
        System.out.println("Записываем  в ячейку с индексом 1 значение ячейки с индексом 2 " +
                "и удаляем значение из ячейки с индексом 2");

        // Записываем в ячейку с индексом 1 значение ячейки с индексом 2
        products[1] = products[2];

        // Удаляем занчение ячейки с индексом 2
        products[2] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        System.out.println('\n');
    }

    public Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}
