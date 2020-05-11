package sportgames.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRW {
    public static List<String> readFile(String path) {
        File file = new File(path);
        Scanner scanner = null;
        List<String> lines = new ArrayList<>();

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            scanner.close();
        }

        return lines;
    }

    public static void writeFile(String path, List<String> value) {
        File file = new File(path);
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
            for (String line:
                    value) {
                printWriter.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Failed to write: " + e.getMessage());
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
