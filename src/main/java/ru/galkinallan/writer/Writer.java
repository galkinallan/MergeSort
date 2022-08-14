package ru.galkinallan.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    public static void write(String fileName, List list) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for(Object str: list) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}
