package com.codekata.fun.binarysearch;

import com.codekata.fun.common.BinarySearchTestSupport;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Author: andrei
 * Date: 4/7/13
 */
@RunWith(JUnit4.class)
public class RecursiveBinarySearchTest extends BinarySearchTestSupport {

    @Before
    public void setUp(){
        binarySearchProvider = new RecursiveBinarySearchProvider();
    }
}
