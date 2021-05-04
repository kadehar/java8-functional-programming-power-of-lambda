package com.github.kadehar.collections;

import java.util.List;
import java.util.Optional;

import static com.github.kadehar.collections.Folks.friends;

public class PickAnElementElegant {
    public static void pickName(final List<String> names,
                                final String startingLetter) {
        final Optional<String> name =
                names.stream()
                        .filter(n -> n.startsWith(startingLetter))
                        .findFirst();

        System.out.println(String.format("A name starting with %s: %s",
                startingLetter, name.orElse("No name found")));
    }

    public static void main(String[] args) {
        System.out.println("//" + "START:NAME_OUTPUT");
        pickName(friends, "N");
        pickName(friends, "Z");
        System.out.println("//" + "END:NAME_OUTPUT");

        final Optional<String> name =
                friends.stream().filter(n -> n.startsWith("N")).findFirst();

        System.out.println("//" + "START:CLOSURE_OUTPUT");
        name.ifPresent(n -> System.out.println("Hello " + n));
        System.out.println("//" + "END:CLOSURE_OUTPUT");
    }
}
