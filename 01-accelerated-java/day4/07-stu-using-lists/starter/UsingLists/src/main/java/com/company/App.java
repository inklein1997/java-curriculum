package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static int total (List<Integer> numbers) {

        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (List<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(List<String> strings) {

        String temp = strings.get(0);
        strings.set(0, (strings.get(strings.size() - 1)));
        strings.set((strings.size() - 1), temp);

        return strings;
    }

    public static List<Integer> reverse(ArrayList<Integer> numbers) {

        List<Integer> reversed = new ArrayList<>();

        for(int i = numbers.size() - 1; i >=0; i--) {

            // length - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
            reversed.add(numbers.get(i));
        }

        return reversed;
    }

    public static List<Integer> lessThanFive(ArrayList<Integer> numbers) {

        List<Integer> lessThan = new ArrayList<>();

        for(int num : numbers) {
            if ( num < 5 ) {
                lessThan.add(num);
            }
        }

        if ( lessThan.size() <= 0 ) {
            return null;
        }

        return lessThan;
    }

    //challenge
    public static List<List<Integer>> splitAtFive(ArrayList<Integer> numbers) {

        List<Integer> lessThan = new ArrayList<>();
        List<Integer> moreThan = new ArrayList<>();

        for(int num : numbers) {
            if ( num < 5 ) {
                lessThan.add(num);
            } else {
                moreThan.add(num);
            }
        }

        List<List<Integer>> splitList = new ArrayList<>();

        splitList.add(lessThan);
        splitList.add(moreThan);

        System.out.println(splitList);
        return splitList;
    }

    // Challenge
    public static List<List<String>> evensAndOdds(ArrayList<String> strings) {

        List<String> odds = new ArrayList<>();
        List<String> evens = new ArrayList<>();

        for(int i = 0; i < strings.size(); i++) {
            int currIndex = i/2;
            if( i % 2 == 0 ) {
                evens.add(strings.get(i));
            } else {
                odds.add(strings.get(i));
            }
        }

        List<List<String>> splitList = new ArrayList<>();

        splitList.add(evens);
        splitList.add(odds);

        return splitList;
    }
}
