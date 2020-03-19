package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {

    @Test
    public void whenMax1To2Then2(){
        int result = Max.max(1,2);
        assertThat(result, is(2));
    }

    @Test
    public void whenSecondMaxFrom3(){
        int result = Max.max(1,5,3);
        assertThat(result,is(5));
    }

    @Test
    public void whenThirdMaxFrom4(){
        int result = Max.max(4,5,7,2);
        assertThat(result,is(7));
    }
}
