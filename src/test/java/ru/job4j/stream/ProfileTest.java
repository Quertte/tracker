package ru.job4j.stream;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ProfileTest {
    @Test
    public void address() {
        List<Profile> profiles = Arrays.asList(
                new Profile(
                        new Address("Spb", "Geroev", 26, 2)),
                new Profile(
                        new Address("Moscow", "Lenina", 26, 43)
                ),
                new Profile(
                        new Address("Spb", "Pravdi", 76, 2)
                )
        );

        List<Address> addresses = Arrays.asList(
                new Address("Spb", "Geroev", 26, 2),
                new Address("Moscow", "Lenina", 26, 43),
                new Address("Spb", "Pravdi", 76, 2)
        );
        assertThat(Profiles.collect(profiles), is(addresses));
    }

    @Test
    public void uniqueAdresses() {
        List<Profile> profiles = Arrays.asList(
                new Profile(
                        new Address("Spb", "Geroev", 26, 2)),
                new Profile(
                        new Address("Moscow", "Lenina", 26, 43)
                ),
                new Profile(
                        new Address("Spb", "Geroev", 26, 2)
                )
        );

        List<Address> addresses = Arrays.asList(
                new Address("Moscow", "Lenina", 26, 43),
                new Address("Spb", "Geroev", 26, 2)
        );
        assertThat(Profiles.sorted(profiles), is(addresses));
    }
}
