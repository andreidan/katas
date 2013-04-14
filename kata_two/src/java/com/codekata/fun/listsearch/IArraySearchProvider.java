package com.codekata.fun.listsearch;

/**
 * Author: andrei
 * Date: 4/7/13
 */
public interface IArraySearchProvider {

    public static final int NOT_FOUND_INDEX = -1;

    public int chop(int value, int[] sortedArray);

}
