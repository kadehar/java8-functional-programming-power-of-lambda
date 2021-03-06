package com.github.kadehar.compare;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListSubDirs {
    public static void main(String[] args) {
        {
            List<File> files = new ArrayList<>();

            File[] filesInCurrentDir = new File(".").listFiles();
            for (File file : filesInCurrentDir) {
                File[] filesInSubDir = file.listFiles();
                if (filesInSubDir != null) {
                    files.addAll(Arrays.asList(filesInSubDir));
                } else {
                    files.add(file);
                }
            }

            System.out.println("Count: " + files.size());
        }
        {
            final List<File> files =
                    Stream.of(new File(".").listFiles())
                            .flatMap(file -> file.listFiles() == null ?
                                    Stream.of(file) : Stream.of(file.listFiles()))
                            .collect(Collectors.toList());
            System.out.println("Count: " + files.size());
        }
    }
}
