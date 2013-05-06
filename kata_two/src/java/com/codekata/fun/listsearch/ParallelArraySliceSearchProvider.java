package com.codekata.fun.listsearch;

import com.codekata.fun.tasks.ArraySliceSearchTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;

/**
 * Author: andrei
 * Date: 4/7/13
 */
public class ParallelArraySliceSearchProvider implements IArraySearchProvider {

    private final ExecutorService executorService;
    private final int cpuCores;

    public ParallelArraySliceSearchProvider() {
        cpuCores = Runtime.getRuntime().availableProcessors();
        executorService = Executors.newFixedThreadPool(cpuCores);
    }

    @Override
    public int chop(int value, int[] sortedArray) {
        int foundIndex = NOT_FOUND_INDEX;
        if (sortedArray == null || sortedArray.length == 0) {
            return foundIndex;
        } else {
            CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);

            int slices = 1;
            int sliceLength = sortedArray.length;
            int lastSliceLength = sliceLength;

            // if the array is longer than twice the number of cpu cores, compute the slice length and number of slices
            if (sortedArray.length > 2 * cpuCores) {
                slices = cpuCores;

                sliceLength = sortedArray.length / slices;
                // if the length of the array is not multiple of the number of cores, the last slice
                // will have a bigger length
                lastSliceLength = sliceLength + (sortedArray.length % slices);
            }

            Collection<Future<Integer>> tasks = new ArrayList<Future<Integer>>();

            for (int i = 0; i < slices; i++) {

                int[] arraySlice = null;
                if (i < slices - 1) {
                    arraySlice = new int[sliceLength];
                    System.arraycopy(sortedArray, i * sliceLength, arraySlice, 0, sliceLength);
                } else {
                    arraySlice = new int[lastSliceLength];
                    System.arraycopy(sortedArray, i * sliceLength, arraySlice, 0, lastSliceLength);
                }
                tasks.add(completionService.submit(new ArraySliceSearchTask(value, arraySlice, i * sliceLength)));
            }

            for (int i = 0; i < slices; i++) {
                try {
                    Integer foundIndexByTask = completionService.take().get();
                    if (foundIndexByTask >= 0) {
                        foundIndex = foundIndexByTask;
                        break;
                    }
                }  catch (ExecutionException e) {
                    throw new SearchExecutionException(e.getCause());
                } catch (InterruptedException e) {
                    // oh well ... move along
                }
            }

            for (Future<Integer> future : tasks) {
                future.cancel(true);
            }
        }

        return foundIndex;
    }
}
