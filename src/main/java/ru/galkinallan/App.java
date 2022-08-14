package ru.galkinallan;

import ru.galkinallan.exceptions.NoTypeArgumentsException;
import ru.galkinallan.reader.CommandLineReader;
import ru.galkinallan.reader.FileHandlerReader;
import ru.galkinallan.sorter.Sorter;
import ru.galkinallan.writer.Writer;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class App {
    public static void main(String[] args) throws IOException {

        CommandLineReader commandLineReader = new CommandLineReader(args);
        ArrayList<String> files = new ArrayList<>(commandLineReader.getListOfFiles());      //getting all fileNames
        String output = files.get(0);
        files.remove(0);

        ArrayList<String> inputArgumentTypes;
        try {
            inputArgumentTypes = new ArrayList<>(commandLineReader.getArguments()); // getting argument types
        } catch (NoTypeArgumentsException e) {
            throw new RuntimeException(e);
        }

        FileHandlerReader file;
        Sorter sorter = new Sorter();

        if (commandLineReader.isInteger(inputArgumentTypes)) {
                ArrayList<Integer> result = new ArrayList<>();
                for (String fileName : files) {
                    file = new FileHandlerReader(fileName);
                    result = (ArrayList<Integer>) sorter.sortInt(file.writeToIntegerList(), result);
                }
                if (commandLineReader.isDescending(inputArgumentTypes)) {
                    Collections.reverse(result);
                }
                Writer.write(output, result);

        } else {
            ArrayList<String> result = new ArrayList<>();
            for (String fileName : files) {
                file = new FileHandlerReader(fileName);
                result = (ArrayList<String>) sorter.sortString(file.writeToStringList(), result);
            }
            if (commandLineReader.isDescending(inputArgumentTypes)) {
                Collections.reverse(result);
            }
            Writer.write(output, result);
        }
    }
}
