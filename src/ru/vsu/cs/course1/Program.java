package ru.vsu.cs.course1;

import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.SwingUtils;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;


public class Program {
    public static void printHelp() {
        System.out.println(
                "Использование: java <classname> [INPUT] [OUTPUT] [--window]\n"+
                        "Увеличивает каждый элемент целочисленного массива из файла INPUT на 1. Результат записывается в файл OUTPUT.\n"
        );
    }


    public static void main(String[] args) throws Exception {
        InputArgs inputArgs = null;
        try {
            inputArgs = InputArgs.ParseArgs(args);
        }
        catch (CmdArgsParseError e){
            printHelp();
            System.err.println("Ошибка разбора аргументов коммандной строки");
            System.exit(1);
        }

        if (inputArgs.window) {
            runWindow();
        } else {

            int[] arr = ArrayUtils.readIntArrayFromFile(inputArgs.inputFile);
            java.util.List<Integer> integerList = Arrays.stream(arr).boxed().collect(Collectors.toList());
            java.util.List<Integer> newList = Task.Process(integerList);
            int[] newArr = newList.stream().mapToInt(Integer::intValue).toArray();

            try {
                ArrayUtils.writeArrayToFile(inputArgs.outputFile, newArr);
            } catch (IOException e) {
                System.err.printf("Ошибка при записи массива в файл %s", e);
                System.exit(3);
            }
        }
    }

    public static void runWindow() throws Exception {
        Locale.setDefault(Locale.ROOT);
        //SwingUtils.setLookAndFeelByName("Windows");
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }
}
