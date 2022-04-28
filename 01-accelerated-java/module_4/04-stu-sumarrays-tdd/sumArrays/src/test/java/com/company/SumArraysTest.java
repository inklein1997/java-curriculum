package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumArraysTest {
    @Test
    public void shouldAddArrayValues() {
        int[] nums1 = {1,3,4};
        int[] nums2 = {1,4};

        int[] nums3 = {-1, 3, 6, 1000, 3, 0};
        int[] nums4 = { 0,0,0, 57, -2};
        assertEquals(13, SumArrays.sumArrays(nums1, nums2));
        assertEquals(1066, SumArrays.sumArrays(nums3, nums4));
    }

    @Test
    public void shouldAddEmptyArrays() {
        int[] empty = {};

        assertEquals(0, SumArrays.sumArrays(empty, empty));
    }

    @Test
    public void shouldCreateArrayWithLength() {
        int[] array = {5,6,7,8,9};
        assertArrayEquals(array, SumArrays.arrayify(5,5));

        int[] array1 = {11,12,13,14};
        assertArrayEquals(array1, SumArrays.arrayify(4, 11));
    }

    @Test
    public void shouldReturnEmptyArrayWhenLengthIsNeg() {
        int[] array = {};
        assertArrayEquals(array, SumArrays.arrayify(-1, 0));
    }
}