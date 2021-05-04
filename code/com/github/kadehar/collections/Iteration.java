package com.github.kadehar.collections;

import java.util.function.Consumer;

import static com.github.kadehar.collections.Folks.friends;

public class Iteration {
    public static void main(String[] args) {
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        for (String name : friends) {
            System.out.println(name);
        }

        System.out.println("//" + "START:INTERNAL_FOR_EACH_OUTPUT");
        friends.forEach(new Consumer<String>() {
            public void accept(final String name) {
                System.out.println(name);
            }
        });
        System.out.println("//" + "END:INTERNAL_FOR_EACH_OUTPUT");
    }
}
