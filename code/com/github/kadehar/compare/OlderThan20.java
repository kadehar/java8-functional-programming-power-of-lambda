package com.github.kadehar.compare;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class OlderThan20 {
    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));
        {
            List<Person> olderThan20 = new ArrayList<>();
            people.stream()
                    .filter(person -> person.getAge() > 20)
                    .forEach(olderThan20::add);
            System.out.println("People older than 20: " + olderThan20);
        }
        {
            final List<Person> olderThan20 =
                    people.stream()
                            .filter(person -> person.getAge() > 20)
                            .collect(ArrayList::new,
                                    ArrayList::add,
                                    ArrayList::addAll);
            System.out.println("People older than 20: " + olderThan20);
        }
        {
            final List<Person> olderThan20 =
                    people.stream()
                            .filter(person -> person.getAge() > 20)
                            .collect(toList());
            System.out.println("People older than 20: " + olderThan20);
        }
        {
            final Map<Integer, List<Person>> peopleByAge =
                    people.stream()
                            .collect(groupingBy(Person::getAge));
            System.out.println("Grouped by age: " + peopleByAge);
        }
        {
            final Map<Integer, List<String>> nameOfPeopleByAge =
                    people.stream()
                            .collect(groupingBy(Person::getAge,
                                    mapping(Person::getName,
                                            toList())));
            System.out.println("People grouped by age: " + nameOfPeopleByAge);
        }
        {
            final Comparator<Person> byAge =
                    Comparator.comparing(Person::getAge);
            final Map<Character, Optional<Person>> oldestPersonOfEachLetter =
                    people.stream()
                            .collect(groupingBy(person ->
                                            person.getName().charAt(0),
                                    reducing(BinaryOperator
                                            .maxBy(byAge))));
            System.out.println("Oldest person of each letter:");
            System.out.println(oldestPersonOfEachLetter);
        }
    }
}
