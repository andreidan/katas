package com.codekata.fun.listsearch;

import com.codekata.fun.tasks.ArraySearchTask;
import com.codekata.fun.tasks.ArraySliceSearchTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;

/**
 * Provides a mean to search perform a parallel search over a sorted array.
 *
 * The difference between this implementation and ParallelArraySLICESearchProvider is that the array is NOT
 * sliced, but passed to every line of execution ( basically every thread shares the array but performs the search
 * on different sub-parts )
 *
 * Author: andrei
 * Date: 4/14/13
 */
public class ParallelArraySearchProvider implements IArraySearchProvider {

    private final ExecutorService executorService;
    private final int cpuCores;

    public ParallelArraySearchProvider() {
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

                int start = i*sliceLength;
                int end = i*sliceLength + sliceLength;

                if (i == (slices - 1)) {
                    end = i*sliceLength + lastSliceLength;
                }

                tasks.add(completionService.submit(new ArraySearchTask(sortedArray, start, end, value)));
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
