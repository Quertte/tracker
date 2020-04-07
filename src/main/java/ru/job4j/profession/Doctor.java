package ru.job4j.profession;

public class Doctor extends Profession {

    private int numberOfCalls;

    public int getNumberOfCalls() {
        return numberOfCalls;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public Health diagnose(Pacient pacient) {
        return null;
    }
}
