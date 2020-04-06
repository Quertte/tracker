package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Автобоус поехал");
    }

    @Override
    public void passengers(int count) {
        System.out.println(count + " пассажиров сели в автобус");
    }

    @Override
    public double toFill(int fuel) {
        return  fuel * 49.99;
    }
}
