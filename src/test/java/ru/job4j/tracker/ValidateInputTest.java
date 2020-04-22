package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.channels.ClosedByInterruptException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pr = System.out;
        System.setOut(new PrintStream(out));
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"one","1"}));
        input.askInt("Enter");
        assertThat(
                out.toString(),
                is(String.format("Please enter validate data again.%n"))
        );
        System.setOut(pr);

    }

    @Test
    public void whenInvalidInput2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pr = System.out;
        System.setOut(new PrintStream(out));
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"-1", "1"}));
        input.askInt("Enter",7);
        assertThat(
                out.toString(),
                is(String.format("Please select key from menu.%n"))
        );
        System.setOut(pr);
    }
}
