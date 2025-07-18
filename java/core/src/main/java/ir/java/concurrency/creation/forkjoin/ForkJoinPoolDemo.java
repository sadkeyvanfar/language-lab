package ir.java.concurrency.creation.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * This class demonstrates the use of ForkJoinPool to perform parallel
 * computations.
 * It uses a RecursiveTask to compute the sum of an array of integers.
 * The ForkJoinPool is designed for tasks that can be broken down into smaller
 * subtasks,
 * allowing for efficient parallel execution.
 */
public class ForkJoinPoolDemo {
    // RecursiveTask to compute sum of a range in an array
    static class SumTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 10;
        private final int[] array;
        private final int start;
        private final int end;

        SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            int length = end - start;
            if (length <= THRESHOLD) {
                // Compute sum directly
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                // Split task
                int mid = start + length / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);

                leftTask.fork(); // asynchronously execute left half
                long rightResult = rightTask.compute(); // compute right half directly
                long leftResult = leftTask.join(); // wait and get left half result

                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // 1 to 100
        }

        ForkJoinPool pool = new ForkJoinPool();

        SumTask task = new SumTask(numbers, 0, numbers.length);
        long result = pool.invoke(task);

        System.out.println("Sum of array elements: " + result);
    }
}
