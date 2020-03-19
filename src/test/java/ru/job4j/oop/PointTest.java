package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;


public class PointTest {

    @Test
    public void distance(){
        Point a = new Point(0,0);
        Point b = new Point(0,2);
        double expected = 2.0;
        double result = a.distance(b);
        Assert.assertEquals(expected,result,0.01);
    }

    @Test
    public void distance3d(){
        Point a = new Point(0,0,0);
        Point b = new Point(0,2,4);
        double expected = 4.47;
        double result = a.distance3d(b);
        Assert.assertEquals(expected,result,0.01);
    }
}
