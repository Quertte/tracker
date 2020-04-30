package ru.job4j.sort;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MachineTest {
    @Test
    public void whenEquals() {
        Machine machine = new Machine();
        int[] expected = {};
        int[] rs1 = machine.change(100, 100);
        assertThat(rs1, is(expected));
    }

    @Test
    public void when50by35() {
        Machine machine = new Machine();
        int[] expected = {10, 5};
        int[] rs1 = machine.change(50,35);
        assertThat(rs1,is(expected));
    }
}
