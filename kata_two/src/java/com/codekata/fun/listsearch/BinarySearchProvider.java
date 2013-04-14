package com.codekata.fun.listsearch;

import java.util.Arrays;

/**
 * Author: andrei
 * Date: 4/14/13
 */
public class BinarySearchProvider implements ISortedListSearchProvider {

    @Override
    public int chop(int value, int[] sortedArray) {

        int foundIndex = Arrays.binarySearch(sortedArray, value);

        // Arrays.binarySearch returns (-(insertion point) - 1) if the value is not in the array
        // our contract states that if the value is not in the array we return -1.
        if(foundIndex < 0) {
            foundIndex = NOT_FOUND_INDEX;
        }

        return foundIndex;
    }

}
