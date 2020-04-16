package ru.job4j.strategy;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.StringJoiner;

public class PaintTest {
    // получаем ссылку на стандартный вывод в консоль.
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // Создаем буфер для хранения вывода.
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    //Заменяем стандартный вывод на вывод в пямять для тестирования.
    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    // возвращаем обратно стандартный вывод в консоль.
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }


    @Test
    public void whenDrawSquare() {
        // выполняем действия пишушиее в консоль.
        new Paint().draw(new Square());
        // проверяем результат вычисления
        assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("++++")
                                .add("+     +")
                                .add("+     +")
                                .add("++++")
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(System.lineSeparator())
                                .add("      +     ")
                                .add("    +   +   ")
                                .add("  +  + +  + ")
                                .toString()
                )
        );

    }
}