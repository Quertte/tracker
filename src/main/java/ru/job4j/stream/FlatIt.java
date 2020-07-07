package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
//        Iterable<Iterator<Integer>> iterable = () -> it;
//        return StreamSupport
//                .stream(iterable.spliterator(), false)
//                .flatMap(item -> StreamSupport
//                        .stream(Spliterators.spliteratorUnknownSize(item, Spliterator.ORDERED), false))
//                .collect(Collectors.toList());
        return StreamSupport.
                stream(Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED), false)
                .flatMap(item -> StreamSupport
                        .stream(Spliterators.spliteratorUnknownSize(item, Spliterator.ORDERED), false))
                .collect(Collectors.toList());

    }
}
