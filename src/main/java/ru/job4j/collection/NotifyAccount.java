package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rs1 = new HashSet<>();
        for (Account account : accounts) {
            rs1.add(account);
        }
        return rs1;
    }
}
