package com.github.kadehar.compare;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ListSelectFiles {
    public static void main(String[] args) throws IOException {
        {
            final String[] files =
                    new File("code/com/github/kadehar/compare")
                            .list(new FilenameFilter() {
                                @Override
                                public boolean accept(File dir, String name) {
                                    return name.endsWith(".java");
                                }
                            });
            System.out.println(Arrays.toString(files));
        }
        {
            Files.newDirectoryStream(
                    Paths.get("code/com/github/kadehar/compare"),
                    path -> path.toString().endsWith(".java"))
                    .forEach(System.out::println);
        }
    }
}
