package ru.job4j.pojo;

import java.util.Date;

public class Student {

    private String nameSurnameMiddleName;
    private String group;
    private Date receipted;

    public String getNameSurnameMiddleName() {
        return nameSurnameMiddleName;
    }

    public void setNameSurnameMiddleName(String nameSurnameMiddleName) {
        this.nameSurnameMiddleName = nameSurnameMiddleName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getReceipted() {
        return receipted;
    }

    public void setReceipted(Date receipted) {
        this.receipted = receipted;
    }
}
