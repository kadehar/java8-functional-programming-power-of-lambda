package com.github.kadehar.introduction;

import java.util.Arrays;
import java.util.List;

public class Cities {
    /**
     * This imperative version is noisy and low level; it has several moving parts.
     * We first initialize a smelly boolean flag named found and then walk through each
     * element in the collection. If we found the city we’re looking for, then we set
     * the flag and break out of the loop. Finally we print out the result of our finding.
     */
    public static void findChicagoImperative(final List<String> cities) {
        boolean found = false;
        for (String city : cities) {
            if (city.equals("Chicago")) {
                found = true;
                break;
            }
        }

        System.out.println("Found Chicago?: " + found);
    }

    /**
     * That change improved our code in quite a few ways:
     * • No messing around with mutable variables
     * • Iteration steps wrapped under the hood
     * • Less clutter
     * • Better clarity; retains our focus
     * • Less impedance; code closely trails the business intent
     * • Less error prone
     * • Easier to understand and maintain
     */
    public static void findChicagoDeclarative(final List<String> cities) {
        System.out.println("Found Chicago?: " + cities.contains("Chicago"));
    }

    public static void main(String[] args) {
        final List<String> cities = Arrays.asList("Albany", "Boulder",
                "Chicago", "Denver", "Eugene");

        findChicagoImperative(cities);
        findChicagoDeclarative(cities);
    }
}
