package ru.job4j;

import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {

        ArrayList<String> deliveryCities = new ArrayList<>();

        deliveryCities.add("Spb");
        deliveryCities.add("MSK");
        deliveryCities.add("EKB");
        deliveryCities.add("Vorkuta");

        deliveryCities.add(1, "Paris");

        for (String str : deliveryCities) {
            System.out.println(str);
        }



    }
}
