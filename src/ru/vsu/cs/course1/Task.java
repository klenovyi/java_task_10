package ru.vsu.cs.course1;

import java.util.ArrayList;
import java.util.List;

public class Task {

    public static int copy(List<Integer> src, int srcIndex, List<Integer> dst, int dstIndex, int count) throws IllegalArgumentException {
//Error Handling (add more robust error handling as needed)
        if(srcIndex < 0 || dstIndex < 0 || count < 0){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < count; i++) {
            Integer el = src.get(srcIndex + i);
            dst.add(dstIndex + i,el);
        }
        return count;
    }

    public static List<Integer> createNewList(List<Integer> list1, List<Integer> list2) {
        List<Integer> resultList = new ArrayList<>();
        for (Integer el : list1) {
            resultList.add(el);
        }
        for (Integer el : list2) {
            resultList.add(el);
        }
        bubbleSort(resultList);
        return resultList;
    }

    public static void bubbleSort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}