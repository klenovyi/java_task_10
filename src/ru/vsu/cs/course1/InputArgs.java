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

    // Метод для проверки расширения файла
    private static boolean isValidTxtFile(String fileName) {
        return fileName != null && fileName.endsWith(".txt");
    }

    public static InputArgs ParseArgs(String[] args) throws CmdArgsParseError {

        String inputFile = null;
        String outputFile = null;

        if (args.length == 1 && Objects.equals(args[0], "--window")) {
            return new InputArgs(null, null, true);
        }
        else if (args.length == 2) {
            inputFile = args[0];
            outputFile = args[1];
            for (int i = 0; i < args.length; i++) {
                if (args[i].contains("--input-file")) {
                    inputFile = args[i].split("=")[1];
                }
                if (args[i].contains("--output-file")) {
                    outputFile = args[i].split("=")[1];
                }
            }
        } else if (args.length == 4) {
// Обработка именованных параметров
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-i")) {
                    if (i + 1 < args.length) {
                        inputFile = args[i + 1];
                        i++; // Пропускаем значение
                    } else {
                        throw new CmdArgsParseError("Отсутствует входной файл.");
                    }
                } else if (args[i].equals("-o")) {
                    if (i + 1 < args.length) {
                        outputFile = args[i + 1];
                        i++; // Пропускаем значение
                    } else {
                        throw new CmdArgsParseError("Отсутствует выходной файл.");
                    }
                }
            }
        } else {
            throw new CmdArgsParseError("Неверное количество аргументов.");
        }

// Проверяем, что оба файла были переданы
        if (inputFile == null || outputFile == null) {
            throw new CmdArgsParseError("Ожидаются аргументы: -i INPUT_FILE -o OUTPUT_FILE.");
        }

// Проверяем, что файлы имеют расширение .txt
        if (!isValidTxtFile(inputFile) || !isValidTxtFile(outputFile)) {
            throw new CmdArgsParseError("Файлы должны иметь расширение .txt.");
        }

        return new InputArgs(inputFile, outputFile, false);

    }

}