package com.codekata.fun.common;

import com.codekata.fun.listsearch.IArraySearchProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Author: andrei
 * Date: 4/7/13
 */
@RunWith(JUnit4.class)
public class ArraySearchTestSupport {

    protected IArraySearchProvider searchProvider;

    @Test
    public void testBinarySearch() {
        assertEquals(-1, searchProvider.chop(0, new int[]{}));
        assertEquals(-1, searchProvider.chop(3, new int[]{1}));
        assertEquals(0, searchProvider.chop(1, new int[]{1}));

        assertEquals(0, searchProvider.chop(1, new int[]{1, 3, 5}));
        assertEquals(1, searchProvider.chop(3, new int[]{1, 3, 5}));
        assertEquals(2, searchProvider.chop(5, new int[]{1, 3, 5}));
        assertEquals(-1, searchProvider.chop(0, new int[]{1, 3, 5}));
        assertEquals(-1, searchProvider.chop(2, new int[]{1, 3, 5}));
        assertEquals(-1, searchProvider.chop(4, new int[]{1, 3, 5}));

        assertEquals(0, searchProvider.chop(1, new int[]{1, 3, 5, 7}));
        assertEquals(1, searchProvider.chop(3, new int[]{1, 3, 5, 7}));
        assertEquals(2, searchProvider.chop(5, new int[]{1, 3, 5, 7}));
        assertEquals(3, searchProvider.chop(7, new int[]{1, 3, 5, 7}));
        assertEquals(-1, searchProvider.chop(0, new int[]{1, 3, 5, 7}));
        assertEquals(-1, searchProvider.chop(2, new int[]{1, 3, 5, 7}));
        assertEquals(-1, searchProvider.chop(4, new int[]{1, 3, 5, 7}));
        assertEquals(-1, searchProvider.chop(6, new int[]{1, 3, 5, 7}));
        assertEquals(-1, searchProvider.chop(8, new int[]{1, 3, 5, 7}));

        assertEquals(-1, searchProvider.chop(8, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(-1, searchProvider.chop(2, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(-1, searchProvider.chop(4, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(-1, searchProvider.chop(25, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(3, searchProvider.chop(7, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(4, searchProvider.chop(9, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(5, searchProvider.chop(11, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(6, searchProvider.chop(12, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(7, searchProvider.chop(13, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(8, searchProvider.chop(14, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(9, searchProvider.chop(15, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(10, searchProvider.chop(16, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(11, searchProvider.chop(17, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(12, searchProvider.chop(18, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(13, searchProvider.chop(19, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(14, searchProvider.chop(20, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(15, searchProvider.chop(21, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(16, searchProvider.chop(22, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(17, searchProvider.chop(23, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));
        assertEquals(18, searchProvider.chop(24, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24}));

        assertEquals(-1, searchProvider.chop(8, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(-1, searchProvider.chop(2, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(-1, searchProvider.chop(4, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(-1, searchProvider.chop(26, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(3, searchProvider.chop(7, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(4, searchProvider.chop(9, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(5, searchProvider.chop(11, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(6, searchProvider.chop(12, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(7, searchProvider.chop(13, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(8, searchProvider.chop(14, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(9, searchProvider.chop(15, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(10, searchProvider.chop(16, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(11, searchProvider.chop(17, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(12, searchProvider.chop(18, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(13, searchProvider.chop(19, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(14, searchProvider.chop(20, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(15, searchProvider.chop(21, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(16, searchProvider.chop(22, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(17, searchProvider.chop(23, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));
        assertEquals(18, searchProvider.chop(24, new int[]{1, 3, 5, 7, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}));

        int tenMillionElementsArray[] = new int[10000000];
        for (int i=0; i<10000000; i++) {
            tenMillionElementsArray[i] = i;
        }
        assertEquals(22001, searchProvider.chop(22001, tenMillionElementsArray));
        assertEquals(9500000, searchProvider.chop(9500000, tenMillionElementsArray));
    }
}
