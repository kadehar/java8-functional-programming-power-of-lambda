package com.github.kadehar.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.kadehar.collections.Folks.friends;

public class PickElements {
    public static void main(String[] args) {
        final List<String> startsWithN = new ArrayList<>();
        for (String name : friends) {
            if (name.startsWith("N")) {
                startsWithN.add(name);
            }
        }
        System.out.println(String.format("Found %d names", startsWithN.size()));

        System.out.println("//" + "START:FILTER_OUTPUT");
        final List<String> withN =
                friends.stream()
                        .filter(name -> name.startsWith("N"))
                        .collect(Collectors.toList());
        System.out.println(String.format("Found %d names", withN.size()));
        System.out.println("//" + "END:FILTER_OUTPUT");
    }
}
