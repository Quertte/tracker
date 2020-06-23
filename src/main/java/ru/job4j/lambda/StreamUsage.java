package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private String name;
        private long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{" + "name='"
                    + name + '\'' + ", spent="
                    + spent + '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );

        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);

        List<String> names = tasks.stream().map(task -> task.name).collect(Collectors.toList());
        names.forEach(System.out::println);

        long total = tasks.stream().map(task -> task.spent).reduce(0L, Long::sum);
        System.out.println(total);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(-20);
        list.add(-30);
        list.add(6565);
        list.add(5);
        list.add(2020);

        List<Integer> filter = list.stream().filter(
                integer -> integer > 0).collect(Collectors.toList());
        filter.forEach(System.out::println);
    }
}
