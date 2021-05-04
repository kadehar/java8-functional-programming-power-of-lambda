package com.github.kadehar.collections;

import java.util.function.Function;
import java.util.function.Predicate;

import static com.github.kadehar.collections.Folks.friends;

public class PickDifferentNames {
    public static void main(String[] args) {
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        final Predicate<String> startsWithB = name -> name.startsWith("B");

        final long countN =
                friends.stream()
                        .filter(startsWithN).count();
        final long countB =
                friends.stream()
                        .filter(startsWithB).count();
        System.out.println(countN);
        System.out.println(countB);

        final long countIfN = friends.stream()
                .filter(checkIfStartsWith("N")).count();
        final long countIfB = friends.stream()
                .filter(checkIfStartsWith("B")).count();
        System.out.println(countIfN);
        System.out.println(countIfB);

        final Function<String, Predicate<String>> withLetter =
                (String letter) -> {
                    Predicate<String> check = (String name) -> name.startsWith(letter);
                    return check;
                };

        final Function<String, Predicate<String>> startsWith =
                (String letter) -> (String name) -> name.startsWith(letter);

        final Function<String, Predicate<String>> startsWithLetter =
                letter -> name -> name.startsWith(letter);

        final long withN = friends.stream()
                .filter(startsWithLetter.apply("N")).count();
        final long withB = friends.stream()
                .filter(startsWithLetter.apply("B")).count();
        System.out.println(withN);
        System.out.println(withB);
    }

    public static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }
}
