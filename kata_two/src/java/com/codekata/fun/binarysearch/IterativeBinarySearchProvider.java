package com.codekata.fun.binarysearch;

/**
 * Author: andrei
 * Date: 4/7/13
 */
public class IterativeBinarySearchProvider implements IBinarySearchProvider {

    private static final int NOT_FOUND_INDEX = -1;

    public int chop(int value, int[] sortedArray) {

        if(sortedArray == null || sortedArray.length == 0 ) {
            return  NOT_FOUND_INDEX;
        } else {
            int startIndex = 0;
            int endIndex = sortedArray.length -1 ;

            while (startIndex <= endIndex) {

                int middleIndex = (endIndex + startIndex) / 2;

                int middleValue = sortedArray[middleIndex];

                if (value == middleValue) {
                    // found the value
                    return middleIndex;
                } else if (value < middleValue) {
                    // search in the bottom half of the array
                    endIndex = middleIndex-1;
                } else {
                    // search in the upper half of the array
                    startIndex = middleIndex + 1;
                }
            }
        }

        // not found
        return NOT_FOUND_INDEX;
    }

}
