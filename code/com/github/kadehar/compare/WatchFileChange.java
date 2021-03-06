package com.github.kadehar.compare;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class WatchFileChange {
    public static void watchFileChange() {
        final Path path = Paths.get(".");
        try {
            final WatchService watchService =
                    path.getFileSystem().newWatchService();
            path.register(watchService,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            System.out.println("Report any file changed within next 1 minute...");

            final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
            if (watchKey != null) {
                watchKey.pollEvents()
                        .forEach(event -> System.out.println(event.context()));
            }
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(WatchFileChange::watchFileChange).start();
        final File file = new File("sample.txt");
        file.createNewFile();
        Thread.sleep(5000);
        file.setLastModified(System.currentTimeMillis());
    }
}
