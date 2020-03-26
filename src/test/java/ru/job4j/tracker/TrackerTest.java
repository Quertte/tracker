package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void testName(){
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item1 = new Item("test1");
        tracker.add(item);
        tracker.add(item1);
        Item[] result = tracker.findByName(item.getName());
        assertThat(result,is(new Item[]{item,item1}));
    }

    @Test
    public void testAll(){
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item item1 = new Item("test2");
        Item item2 = new Item("test3");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item[] result = tracker.findAll();
        assertThat(result,is(new Item[]{item,item1,item2}));
    }


}
