package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority(){
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rs1 = cmpNamePriority.compare(new Job("Impl task", 0),new Job("Fix bug", 1));
        assertThat(rs1, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityAsc(){
        Comparator<Job> cmpPriorityAsc = new JobAscByPriority();
        int rs1 = cmpPriorityAsc.compare(new Job("Impl task", 0),new Job("Fix bug", 1));
        assertThat(rs1,lessThan(0));
    }

    @Test
    public void whenComparatorByNameAsc(){
        Comparator<Job> cmpNameAsc = new JobAscByName();
        int rs1 = cmpNameAsc.compare(new Job("Impl task", 0),new Job("Fix bug", 1));
        assertThat(rs1,greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityDesc(){
        Comparator<Job> cmpPriorityDesc = new JobDescByPriority();
        int rs1 = cmpPriorityDesc.compare(new Job("Impl task", 0),new Job("Fix bug", 1));
        assertThat(rs1,greaterThan(0));
    }

    @Test
    public void whenComparatorByNameDesc(){
        Comparator<Job> cmpNameDesc = new JobDescByName();
        int rs1 = cmpNameDesc.compare(new Job("Impl task", 0),new Job("Fix bug", 1));
        assertThat(rs1,lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityAndName(){
        Comparator<Job> cmpPriorityName = new JobAscByPriority().thenComparing(new JobAscByName());
        int rs1 = cmpPriorityName.compare(new Job("Impl task", 1),new Job("Fix bug", 1));
        assertThat(rs1,greaterThan(0));
    }



}
