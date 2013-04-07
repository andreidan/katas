package com.codekata.fun.listsearch;

import com.codekata.fun.util.ArrayUtils;

/**
 * Author: andrei
 * Date: 4/7/13
 */
public class RecursiveSortedListSearchProvider implements ISortedListSearchProvider {

    private static final int NOT_FOUND_INDEX = -1;

    public int chop(int value, int[] sortedArray) {

        if (sortedArray == null || sortedArray.length == -1) {
            return NOT_FOUND_INDEX;
        }

        return chop(value, sortedArray, 0, sortedArray.length - 1);
    }

    private int chop(int value, int[] sortedArray, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return NOT_FOUND_INDEX;
        } else {

            int middleIndex = ArrayUtils.getMiddleIndex(startIndex, endIndex);
            int middleValue = sortedArray[middleIndex];

            if (value < middleValue) {
                endIndex = middleIndex - 1;
                return chop(value, sortedArray, startIndex, endIndex);
            } else if (value > middleValue) {
                startIndex = middleIndex + 1;
                return chop(value, sortedArray, startIndex, endIndex);
            } else {
                return middleIndex;
            }
        }
    }
}
