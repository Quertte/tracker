package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setNameSurnameMiddleName("Andrew Nedogibchenko Aleksandrovich");
        student.setGroup("B");
        student.setReceipted(new Date());

        System.out.println(student.getNameSurnameMiddleName() + " учиться в группе " + student.getGroup());
    }
}
