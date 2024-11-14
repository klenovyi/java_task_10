package ru.vsu.cs.course1;


import java.util.ArrayList;
import java.util.List;

public class Task {
    public static List<Integer> Process(List<Integer> list) {
        List<Integer> newList = new ArrayList();

        for (Integer a : list){
            newList.add(a+1);
        }

        return newList;
    }
}
