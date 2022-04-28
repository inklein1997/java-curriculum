package com.company;

import java.util.List;
import java.util.LinkedList;

public class LinkedListApp {

    public static int total (LinkedList<Integer> numbers) {

        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (LinkedList<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    public static List<String> swapFirstAndLast(LinkedList<String> strings) {

        String temp = strings.get(0);
        strings.set( 0, strings.get( strings.size() - 1 ) );
        strings.set( strings.size() - 1, temp );

        return strings;
    }

    public static List<Integer> reverse(LinkedList<Integer> numbers) {

        List<Integer> reversed = new LinkedList<>();

        for(int i = numbers.size() - 1; i >= 0 ; i--) {

            reversed.add(numbers.get(i));
        }

        return reversed;
    }

    public static List<Integer> lessThanFive(LinkedList<Integer> numbers) {

        List<Integer> lessThan = new LinkedList<>();

        for(int num : numbers) {
            if ( num < 5 ) {
                lessThan.add(num);
            }
        }

        if (lessThan.size() > 0){
            return lessThan;
        } else return null;
    }

    //challenge
    public static List<List<Integer>> splitAtFive(LinkedList<Integer> numbers) {

        List<Integer> lessThan = new LinkedList<>();
        List<Integer> moreThan = new LinkedList<>();


        for(int num : numbers) {
            if ( num < 5 ) {
                lessThan.add(num);
            } else {
                moreThan.add(num);
            }
        }

        List<List<Integer>> splitList = new LinkedList<>();

        splitList.add(lessThan);
        splitList.add(moreThan);

        return splitList;
    }

    // Challenge
    public static List<List<String>> evensAndOdds(LinkedList<String> strings) {

        List<String> odds = new LinkedList<>();
        List<String> evens = new LinkedList<>();

        for(int i = 0; i < strings.size(); i++) {
            int currIndex = i/2;
            if( i % 2 == 0 ) {
                evens.add(strings.get(i));
            } else {
                odds.add(strings.get(i));
            }
        }

        List<List<String>> splitList = new LinkedList<>();

        splitList.add(evens);
        splitList.add(odds);

        return splitList;
    }
}
