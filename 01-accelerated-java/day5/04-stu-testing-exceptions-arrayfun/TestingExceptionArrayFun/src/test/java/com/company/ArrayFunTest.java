package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayFunTest {
    private ArrayFun array;

    @Before
    public void setUp() throws Exception {
        array = new ArrayFun();
    }

    @Test
    public void shouldReturnAveragesOfListsInList() {
        List<Integer> list1a = Arrays.asList(1,2,3);
        List<Integer> list1b = Arrays.asList(4,5,6);
        List<List<Integer>> list2 = Arrays.asList(list1a, list1b);

        List expectedList = Arrays.asList(2,5);

        assertEquals(expectedList, ArrayFun.averageList(list2));
    }
}