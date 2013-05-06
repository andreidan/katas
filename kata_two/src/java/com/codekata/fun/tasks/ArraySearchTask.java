package com.codekata.fun.tasks;

import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * Author: andrei
 * Date: 5/6/13
 */
public class ArraySearchTask implements Callable<Integer> {

    final int[] sortedArray;
    final int start;
    final int end;
    final int key;

    public ArraySearchTask(int[] sortedArray, int start, int end, int key) {
        this.sortedArray = sortedArray;
        this.start = start;
        this.end = end;
        this.key = key;
    }

    @Override
    public Integer call() throws Exception {
        int foundIndex = Arrays.binarySearch(sortedArray, start, end, key);

        if(foundIndex<0)
        {
            foundIndex = -1;
        }

        return foundIndex;
    }

}
