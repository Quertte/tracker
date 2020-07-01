package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> opt = findByPassport(passport);
        if (opt.isPresent()) {
            if (!users.get(opt.get()).contains(account)) {
                users.get(opt.get()).add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        //User user = null;
        return users.keySet()
                .stream()
                .filter(e -> e.getPassport().equals(passport))
                .findFirst();

//        for (User psp : users.keySet()) {
//            if (psp.getPassport().equals(passport)) {
//                user = psp;
//                break;
//            }
//        }
    }

    public Optional<Account> findByRequisites(String passport, String requisites) {
      //  Account account = null;
        Optional<User> user = findByPassport(passport);
       // if (user != null) {
//            for (Account acc : users.get(user)) {
//                if (acc.getRequisite().equals(requisites)) {
//                    account = acc;
//                    break;
//                }
//            }
//        }
//        return account;

       // }
        return  users.get(user.get()).stream().filter(
                e -> e.getRequisite().equals(requisites)).findFirst();
    }

    public boolean transfersMoney(String srcPassport, String srcRequisites,
                                  String destPassport, String destRequisites, double amount) {
        boolean rs1 = true;
        Optional<Account> account = findByRequisites(srcPassport, srcRequisites);
        Optional<Account> account1 = findByRequisites(destPassport, destRequisites);
        if (account.isEmpty() || account1.isEmpty() || account.get().getBalance() < amount) {
            rs1 = false;
        } else {
            account.get().setBalance(account.get().getBalance() - amount);
            account1.get().setBalance(account1.get().getBalance() + amount);
        }
        return rs1;
    }
}
