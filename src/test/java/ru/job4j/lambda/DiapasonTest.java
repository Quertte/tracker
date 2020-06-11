package ru.job4j.lambda;

import org.junit.Test;

import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;


public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Diapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunction() {
        List<Double> result = Diapason.diapason(5, 8, x -> 2 * Math.pow(x, 2) + 1 * x + 3);
        List<Double> expected = Arrays.asList(58D, 81D, 108D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenIndicativeFunction() {
        List<Double> result = Diapason.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result, is(expected));

    }
}
