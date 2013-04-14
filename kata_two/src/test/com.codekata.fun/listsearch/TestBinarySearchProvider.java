package com.codekata.fun.listsearch;

import com.codekata.fun.common.SortedListSearchTestSupport;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Author: andrei
 * Date: 4/14/13
 */
@RunWith(JUnit4.class)
public class TestBinarySearchProvider extends SortedListSearchTestSupport {
    @Before
    public void setUp() throws Exception {
        searchProvider = new BinarySearchProvider();
    }
}
