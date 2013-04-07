package com.codekata.fun.util;

/**
 * Author: andrei
 * Date: 4/7/13
 */
public class ArrayUtils {

    public static int getEndIndex(int[] array) {
        return array.length - 1;
    }

    public static int getMiddleIndex(int startIndex, int endIndex) {
        return (startIndex + endIndex) / 2;
    }

}
