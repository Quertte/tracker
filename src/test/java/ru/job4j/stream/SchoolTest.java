package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.stream.School;
import ru.job4j.stream.Student;

import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenA(){
        List<Student> students = Arrays.asList(
                new Student(100, "Litvinov"),
                new Student(80, "Kozlov"),
                new Student(45, "Mitiev"),
                new Student(20, "Ivanov"),
                new Student(60, "Petrov")
        );
        List<Student> result = School.collect(students, student -> student.getScore() >= 70 && student.getScore()<=100);
        List<Student> expected = Arrays.asList(
                new Student(100, "Litvinov"),
                new Student(80, "Kozlov")
        );
        assertThat(result,is(expected));
    }
    @Test
    public void whenB(){
        List<Student> students = Arrays.asList(
                new Student(100, "Litvinov"),
                new Student(80, "Kozlov"),
                new Student(50, "Mitiev"),
                new Student(20, "Ivanov"),
                new Student(60, "Petrov")
        );
        List<Student> result = School.collect(students, student -> student.getScore() >= 50 && student.getScore() < 70);
        List<Student> expected = Arrays.asList(
                new Student(50, "Mitiev"),
                new Student(60, "Petrov")
        );
        assertThat(result,is(expected));
    }

    @Test
    public void whenc(){
        List<Student> students = Arrays.asList(
                new Student(100, "Litvinov"),
                new Student(80, "Kozlov"),
                new Student(50, "Mitiev"),
                new Student(20, "Ivanov"),
                new Student(60, "Petrov")
        );
        List<Student> result = School.collect(students, student -> student.getScore() > 0 && student.getScore() < 50);
        List<Student> expected = Arrays.asList(
                new Student(20, "Ivanov")
        );
        assertThat(result,is(expected));
    }
}
