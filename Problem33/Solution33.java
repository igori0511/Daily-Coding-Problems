import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * This problem was asked by Microsoft.
 * Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.
 * <p>
 * Recall that the median of an even-numbered list is the average of the two middle numbers.
 * For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
 * <p>
 * 2
 * 1.5
 * 2
 * 3.5
 * 2
 * 2
 * 2
 */
public class Solution33 {

    public static void addNumber(int number, PriorityQueue<Integer> lowers,
                                 PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    public static void rebalance(PriorityQueue<Integer> lowers,
                                 PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lowers,
                                   PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() == smallerHeap.size()) {
            return (biggerHeap.peek() + smallerHeap.peek()) / 2.0f;
        }
        return biggerHeap.peek();

    }

    public static double[] getMedians(int[] array) {
        // max heap
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
        // min heap
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        double[] medians = new double[array.length];
        int i = 0;
        for (int number : array) {
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians[i++] = getMedian(lowers, highers);
        }

        return medians;
    }

    public static void main(String[] args) {
        int[] runningMediansArray = {2, 1, 5, 7, 2, 0, 5};
        System.out.println(Arrays.toString(getMedians(runningMediansArray)));
    }
}