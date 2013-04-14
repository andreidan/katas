package com.codekata.fun.tasks;

import com.sun.corba.se.impl.logging.ORBUtilSystemException;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Author: andrei
 * Date: 4/7/13
 */
public class ArraySliceSearchTask implements Callable<Integer> {

    private final int[] sortedArray;
    private final int value;
    private final int startIndex;

    /**
     * Creates a task that searches the provided @param sortedArray for the provided @param value.
     * The startIndex indicates from where in a possible original array are we starting to search. For eg. if
     * we sliced the original array in 2, the second task will have the startIndex = originaArray.length / 2. We need this
     * information because if we found the value on position 0 in the SLICED array, we want to return the index in the
     * originalArray ( in our case that would be originaArray.length/2 )
     *
     * @param value
     * @param sortedArray
     * @param startIndex
     */
    public ArraySliceSearchTask(int value, int[] sortedArray, int startIndex) {
        this.value = value;
        this.sortedArray = sortedArray;
        this.startIndex = startIndex;
    }

    @Override
    public Integer call() throws Exception {

        int foundIndex = Arrays.binarySearch(sortedArray, value);

        if(foundIndex >= 0 && startIndex > 0)
        {
            foundIndex = startIndex + foundIndex;
        }

        return foundIndex;
    }
}
