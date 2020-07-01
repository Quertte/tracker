package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /*
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateSurname = person -> person.getSurname().contains(key);
        Predicate<Person> predicateName = person -> person.getName().contains(key);
        Predicate<Person> predicateAddress = person -> person.getAddress().contains(key);
        Predicate<Person> predicatePhone = person -> person.getPhone().contains(key);
        Predicate<Person> combine = predicateSurname.or(predicateName).or(predicateAddress).or(predicatePhone);

        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
//            if (person.getSurname().contains(key) || person.getName().contains(key)
//                    || person.getAddress().contains(key) || person.getPhone().contains(key)) {
//                result.add(person);
//            }
        }
        return result;
    }

}
