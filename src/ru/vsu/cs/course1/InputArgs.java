package ru.vsu.cs.course1;

/*
Класс для хранения пути входного и выходного файла
 */

import java.util.Objects;

public class InputArgs {
    public String inputFile;
    public String outputFile;
    public boolean window;

    public InputArgs(String inputFile, String outputFile, boolean window){
        this.window = window;
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public static InputArgs ParseArgs(String[] args) throws CmdArgsParseError {
        if (args.length == 2) {
            return new InputArgs(args[0], args[1], false);
        } else if (args.length == 1 && Objects.equals(args[0], "--window")) {
            return new InputArgs(null, null, true);
        }
        throw new CmdArgsParseError();

    }

}