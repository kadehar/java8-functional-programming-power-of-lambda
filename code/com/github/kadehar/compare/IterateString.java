package com.github.kadehar.compare;

public class IterateString {
    private static void printChar(int aChar) {
        System.out.println((char) aChar);
    }

    public static void main(String[] args) {
        final String str = "w00t";

        str.chars().forEach(System.out::println);

        System.out.println("// START FIX_OUTPUT");
        str.chars().forEach(IterateString::printChar);
        System.out.println("// STOP FIX_OUTPUT");

        System.out.println("// START BETTER_FIX");
        str.chars()
                .mapToObj(ch -> (char) ch)
                .forEach(System.out::println);
        System.out.println("// STOP BETTER_FIX");
        System.out.println("// START FILTER_OUTPUT");
        str.chars()
                .filter(Character::isDigit)
                .forEach(IterateString::printChar);
        System.out.println("// STOP FILTER_OUTPUT");
    }
}
