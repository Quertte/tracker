package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rs1 = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rs1 = i;
                break;
            }
        }
        if (rs1 == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rs1;
    }

    public static void main(String[] args) {
        String[] value = {"Andrew", "Marina", "Ura"};
        try {
            indexOf(value, "Andew");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
