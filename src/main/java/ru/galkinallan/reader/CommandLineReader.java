package ru.galkinallan.reader;

import ru.galkinallan.exceptions.NoTypeArgumentsException;

import java.util.ArrayList;
import java.util.List;

public class CommandLineReader {
    private String[] args;

    public CommandLineReader(String[] args) {
        this.args = args;
    }

    public Boolean isInteger(List<String> list) {
        if (list.contains("-s")){
            return false;
        }
        return true;
    }

    public Boolean isDescending(List<String> list) {
        if (list.contains("-d")) {
            return true;
        }
        return false;
    }

    public List getArguments() throws NoTypeArgumentsException {
        List<String> arguments = new ArrayList<>();
        for (String arg : args) {
            if (arg.contains("-") && !arg.contains(".txt")) {
                arguments.add(arg);
            }
            if (arguments == null || !arguments.contains("-s") && !arguments.contains("-i")) {
                throw new NoTypeArgumentsException("No argument type exception");
            }
        }
        return arguments;
    }

    public List getListOfFiles() {
        List<String> files = new ArrayList<>();
        for (String arg : args) {
            if (arg.contains(".txt")) {
                files.add(arg);
            }
        }
        return files;
    }

}
