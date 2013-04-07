package com.codekata.fun.listsearch;

import com.codekata.fun.common.SortedListSearchTestSupport;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Author: andrei
 * Date: 4/7/13
 */
@RunWith(JUnit4.class)
public class IterativeBinaryListTest extends SortedListSearchTestSupport {

    @Before
    public void setUp() {
        searchProvider = new IterativeSortedListSearchProvider();
    }

//    @Test
//    public void testBinarySearch() {
//        searchProvider = new IterativeSortedListSearchProvider();
//        assertEquals(-1, searchProvider.chop(0, new int[]{}));
//        assertEquals(-1, searchProvider.chop(3, new int[]{1}));
//        assertEquals(0, searchProvider.chop(1, new int[]{1}));
//
//        assertEquals(0, searchProvider.chop(1, new int[]{1, 3, 5}));
//        assertEquals(1, searchProvider.chop(3, new int[]{1, 3, 5}));
//        assertEquals(2, searchProvider.chop(5, new int[]{1, 3, 5}));
//        assertEquals(-1, searchProvider.chop(0, new int[]{1, 3, 5}));
//        assertEquals(-1, searchProvider.chop(2, new int[]{1, 3, 5}));
//        assertEquals(-1, searchProvider.chop(4, new int[]{1, 3, 5}));
//
//        assertEquals(0, searchProvider.chop(1, new int[]{1, 3, 5, 7}));
//        assertEquals(1, searchProvider.chop(3, new int[]{1, 3, 5, 7}));
//        assertEquals(2, searchProvider.chop(5, new int[]{1, 3, 5, 7}));
//        assertEquals(3, searchProvider.chop(7, new int[]{1, 3, 5, 7}));
//        assertEquals(-1, searchProvider.chop(0, new int[]{1, 3, 5, 7}));
//        assertEquals(-1, searchProvider.chop(2, new int[]{1, 3, 5, 7}));
//        assertEquals(-1, searchProvider.chop(4, new int[]{1, 3, 5, 7}));
//        assertEquals(-1, searchProvider.chop(6, new int[]{1, 3, 5, 7}));
//        assertEquals(-1, searchProvider.chop(8, new int[]{1, 3, 5, 7}));
//    }

}
