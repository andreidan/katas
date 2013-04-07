package com.codekata.fun.binarysearch;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Author: andrei
 * Date: 4/7/13
 */
@RunWith(JUnit4.class)
public class TestIterativeBinarySearch {

    private IBinarySearchProvider binarySearchProvider;

    @Before
    public void setUp() {
        binarySearchProvider = new IterativeBinarySearchProvider();
    }

    @Test
    public void testBinarySearch() {
        assertEquals(-1, binarySearchProvider.chop(0, new int[]{}));
        assertEquals(-1, binarySearchProvider.chop(3, new int[]{1}));
        assertEquals(0, binarySearchProvider.chop(1, new int[]{1}));

        assertEquals(0, binarySearchProvider.chop(1, new int[]{1, 3, 5}));
        assertEquals(1, binarySearchProvider.chop(3, new int[]{1, 3, 5}));
        assertEquals(2, binarySearchProvider.chop(5, new int[]{1, 3, 5}));
        assertEquals(-1, binarySearchProvider.chop(0, new int[]{1, 3, 5}));
        assertEquals(-1, binarySearchProvider.chop(2, new int[]{1, 3, 5}));
        assertEquals(-1, binarySearchProvider.chop(4, new int[]{1, 3, 5}));

        assertEquals(0, binarySearchProvider.chop(1, new int[]{1, 3, 5, 7}));
        assertEquals(1, binarySearchProvider.chop(3, new int[]{1, 3, 5, 7}));
        assertEquals(2, binarySearchProvider.chop(5, new int[]{1, 3, 5, 7}));
        assertEquals(3, binarySearchProvider.chop(7, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binarySearchProvider.chop(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binarySearchProvider.chop(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binarySearchProvider.chop(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binarySearchProvider.chop(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, binarySearchProvider.chop(8, new int[]{1, 3, 5, 7}));
    }

}
