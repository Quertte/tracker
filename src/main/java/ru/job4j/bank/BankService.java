package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User psp : users.keySet()) {
            if (psp.getPassport().equals(passport)) {
                user = psp;
                break;
            }
        }
        return user;
    }

    public Account findByRequisites(String passport, String requisites) {
        Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account acc : users.get(user)) {
                if (acc.getRequisite().equals(requisites)) {
                    account = acc;
                    break;
                }
            }
        }
        return account;
    }

    public boolean transfersMoney(String srcPassport, String srcRequisites,
                                  String destPassport, String destRequisites, double amount) {
        boolean rs1 = true;
        Account account = findByRequisites(srcPassport, srcRequisites);
        Account account1 = findByRequisites(destPassport, destRequisites);
        if (account == null || account1 == null || account.getBalance() < amount) {
            rs1 = false;
        } else {
            account.setBalance(account.getBalance() - amount);
            account1.setBalance(account1.getBalance() + amount);
        }
        return rs1;
    }
}
