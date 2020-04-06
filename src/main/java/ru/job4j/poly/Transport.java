package ru.job4j.poly;

public interface Transport {

    void go();

    void passengers(int count);

    double toFill(int fuel);
}
