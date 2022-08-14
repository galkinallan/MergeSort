package ru.galkinallan.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandlerReader {


    private final Scanner scanner;

    public FileHandlerReader(String name) throws FileNotFoundException {
        File file = new File(name);
        scanner = new Scanner(file);
    }

    public List<Integer> writeToIntegerList() {
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            try {
                list.add(Integer.parseInt(scanner.nextLine()));
            } catch (NumberFormatException nfe) {

            }
        }
        return list;
    }

    public List<String> writeToStringList() {
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        return list;
    }


}
