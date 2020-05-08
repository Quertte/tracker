package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.nullValue;

public class StartUITest {

    @Test
    public void whenAddItem() {
        List<String> answers = List.of("Fix PC");
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        new CreateAction().execute(input, tracker);
        Item created = tracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem(){
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        List<String> answers = List.of(item.getId(), "replaced item");
        new ReplaceActions().execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(),is("replaced item"));
    }

    @Test
    public void whenDeleteItem(){
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        List<String> answers = List.of(item.getId());
        new DeleteActions().execute(new StubInput(answers),tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted,is(nullValue()));
    }

    @Test
    public void whenExit(){
        StubInput input = new StubInput(new ArrayList<>(List.of("0")));
        StubAction action = new StubAction();
        List<UserAction> list = List.of(action);
        new StartUI().init(input, new Tracker(),list);
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new ArrayList<>(List.of("0"))
        );
        StubAction action = new StubAction();
        List<UserAction> list = List.of(action);
        new StartUI().init(input, new Tracker(), list);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0)Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }


}
