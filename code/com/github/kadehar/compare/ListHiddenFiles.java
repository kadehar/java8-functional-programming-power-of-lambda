package com.github.kadehar.compare;

import java.io.File;
import java.util.Arrays;

public class ListHiddenFiles {
    public static void main(String[] args) {
        {
            final File[] files = new File(".").listFiles(File::isHidden);
            System.out.println(Arrays.toString(files));
        }
    }
}
