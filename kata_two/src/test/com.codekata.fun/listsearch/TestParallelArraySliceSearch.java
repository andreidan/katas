package com.codekata.fun.listsearch;

import com.codekata.fun.common.ArraySearchTestSupport;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Author: andrei
 * Date: 4/7/13
 */
@RunWith(JUnit4.class)
public class TestParallelArraySliceSearch extends ArraySearchTestSupport {

    @Before
    public void setUp() {
        searchProvider = new ParallelArraySliceSearchProvider();
    }
}
