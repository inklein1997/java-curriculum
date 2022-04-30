package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator {

    public void printSet(int num1, int num2, int num3, int num4, int num5) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(num1);
        numbers.add(num2);
        numbers.add(num3);
        numbers.add(num4);
        numbers.add(num5);

        Iterator itr = numbers.iterator();

        while(itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
