package com.github.kadehar.collections;

import java.util.ArrayList;
import java.util.List;

import static com.github.kadehar.collections.Folks.friends;

public class Transform {
    public static void main(String[] args) {
        final List<String> uppercaseNames = new ArrayList<>();

        for (String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }
        System.out.println(uppercaseNames);

        final List<String> uppercaseNames2 = new ArrayList<>();
        friends.forEach(name -> uppercaseNames2.add(name.toUpperCase()));
        System.out.println(uppercaseNames2);

        System.out.println("//" + "START:TRANSFORM_OUTPUT");
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.print(name + " "));
        System.out.println();
        System.out.println("//" + "END:TRANSFORM_OUTPUT");

        System.out.println("//" + "START:NUMBER_OUTPUT");
        friends.stream()
                .map(name -> name.length())
                .forEach(count -> System.out.print(count + " "));
        System.out.println();
        System.out.println("//" + "END:NUMBER_OUTPUT");

        System.out.println("//" + "START:TRANSFORM_OUTPUT");
        friends.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("//" + "END:TRANSFORM_OUTPUT");
    }
}
