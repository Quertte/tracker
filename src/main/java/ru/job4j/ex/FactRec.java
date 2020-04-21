package ru.job4j.ex;

public class FactRec {
    public static int cacl(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return cacl(n - 1) * n;
    }

    public static void main(String[] args) {
        int rs1 = cacl(4);
        System.out.println(rs1);
    }

}
