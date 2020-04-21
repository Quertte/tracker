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
        String[] data = {"one", "1"};
        ValidateInput input = new ValidateStubInput(data);
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
        String[] data = {"-1", "2", "3", ""};
        ValidateInput input = new ValidateStubInput(data);
        input.askInt("Enter",data.length);
        assertThat(
                out.toString(),
                is(String.format("Please select key from menu.%n"))
        );
        System.setOut(pr);

    }

}
