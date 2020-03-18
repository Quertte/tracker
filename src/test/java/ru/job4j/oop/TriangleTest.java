package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {

    @Test
    public void whenExist(){
        Point first = new Point(2,4);
        Point second = new Point(3,5);
        Point third = new Point(5,9);
        Triangle triangle = new Triangle(first,second,third);
        double expected = 0.99;
        double result = triangle.area();
        Assert.assertEquals(expected,result,0.01);
    }

    @Test
    public void whenNoExist(){
        Point first = new Point(0,2);
        Point second = new Point(0,3);
        Point third = new Point(0,1);
        Triangle triangle = new Triangle(first,second,third);
        double expected = -1.0;
        double result = triangle.area();
        Assert.assertEquals(expected,result,0.01);
    }
}
