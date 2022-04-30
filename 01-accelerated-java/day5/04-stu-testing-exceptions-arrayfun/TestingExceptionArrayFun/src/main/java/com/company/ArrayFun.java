package com.company;

import java.util.ArrayList;
import java.util.List;

public class ArrayFun {

    public static List<Integer> averageList(List<List<Integer>> listList) {

        List results = new ArrayList<Integer>();

        for (int i = 0; i < listList.size(); i++) {
            int sum = 0;

            for (int num : listList.get(i)) {
                sum += num;
            }

            int average = sum / listList.get(i).size();

            results.add(average);
        }
        return results;
    }
}
