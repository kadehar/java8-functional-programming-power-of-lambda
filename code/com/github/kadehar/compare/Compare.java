package com.github.kadehar.compare;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Compare {
    private static void printPeople(final String message, final List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }

    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));

        List<Person> ascendingAge = people.stream()
                .sorted(Person::ageDifference)
                .collect(toList());
        printPeople("Sorted in ascending order by age: ", ascendingAge);

        printPeople("Sorted in descending order by age: ",
                people.stream()
                        .sorted((p1, p2) -> p2.ageDifference(p1))
                        .collect(toList()));

        Comparator<Person> compareAscending = Person::ageDifference;
        Comparator<Person> compareDescending = compareAscending.reversed();

        printPeople("Sorted in ascending order by age: ",
                people.stream()
                        .sorted(compareAscending)
                        .collect(toList()));
        printPeople("Sorted in descending order by age: ",
                people.stream()
                        .sorted(compareDescending)
                        .collect(toList()));

        printPeople("Sorted in ascending order by name: ",
                people.stream()
                        .sorted(comparing(Person::getName))
                        .collect(toList()));

        people.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> System.out.println("Youngest: " + youngest));
        people.stream()
                .max(Person::ageDifference)
                .ifPresent(eldest -> System.out.println("Eldest: " + eldest));

        final Function<Person, String> byName = Person::getName;
        people.stream()
                .sorted(comparing(byName))
                .forEach(System.out::println);

        final Function<Person, Integer> byAge = Person::getAge;
        final Function<Person, String> byTheirName = Person::getName;
        printPeople("Sorted in ascending order by age and name: ",
                people.stream()
                        .sorted(comparing(byAge)
                                .thenComparing(byTheirName))
                        .collect(toList()));
    }
}
