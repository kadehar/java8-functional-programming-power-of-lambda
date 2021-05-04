package com.github.kadehar.collections;

import java.util.function.Predicate;

import static com.github.kadehar.collections.Folks.*;

public class PickElementsMultipleCollection {
    public static void main(String[] args) {
        final long countFriendsStartN =
                friends.stream()
                        .filter(name -> name.startsWith("N"))
                        .count();

        final long countEditorsStartN =
                editors.stream()
                        .filter(name -> name.startsWith("N"))
                        .count();

        final long countComradesStartN =
                comrades.stream()
                        .filter(name -> name.startsWith("N"))
                        .count();

        System.out.println(countFriendsStartN);
        System.out.println(countComradesStartN);
        System.out.println(countEditorsStartN);

        final Predicate<String> startsWithN = name -> name.startsWith("N");

        final long friendsCount =
                friends.stream()
                        .filter(startsWithN)
                        .count();

        final long editorsCount =
                editors.stream()
                        .filter(startsWithN)
                        .count();

        final long comradesCount =
                comrades.stream()
                        .filter(startsWithN)
                        .count();

        System.out.println(friendsCount);
        System.out.println(editorsCount);
        System.out.println(comradesCount);
    }
}
