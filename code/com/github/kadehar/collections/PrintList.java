package com.github.kadehar.collections;

import java.util.stream.Collectors;

import static com.github.kadehar.collections.Folks.friends;

public class PrintList {
    public static void main(String[] args) {
        for (String name : friends) {
            System.out.print(name + ", ");
        }
        System.out.println();
        for (int i = 0; i < friends.size() - 1; i++) {
            System.out.print(friends.get(i) + ", ");
        }
        if (friends.size() > 0) {
            System.out.println(friends.get(friends.size() - 1));
        }

        System.out.println(String.join(", ", friends));
        System.out.println(
                friends.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.joining(", "))
        );
    }
}
