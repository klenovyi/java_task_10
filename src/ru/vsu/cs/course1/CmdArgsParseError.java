package ru.vsu.cs.course1;

/*
Собственный класс исключение
*/
public class CmdArgsParseError extends Exception{
    public CmdArgsParseError(String message) {
        System.out.println(message);
    }
}
