import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * This problem was asked by Google.
 * <p>
 * Given an array of integers and a number k, where 1 <= k <= length of the array,
 * compute the maximum values of each subarray of length k.
 * For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
 * <p>
 * 10 = max(10, 5, 2)
 * 7 = max(5, 2, 7)
 * 8 = max(2, 7, 8)
 * 8 = max(7, 8, 7)
 */
public class Solution18 {

    private static void subArrayMax(int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }
        System.out.print(pq.peek() + " ");

        for (int i = k; i < input.length; i++) {
            pq.remove(input[i - k]);
            pq.add(input[i]);
            System.out.print(pq.peek() + " ");
        }
    }

    private static void subArrayMaxEfficient(int[] input, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        /* Preprocessing phase */
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && input[i] >= input[deque.peekLast()])
                deque.pop();
            deque.add(i);
        }
        /* Core processing */
        for (int i = k; i < input.length; i++) {
            System.out.print(input[deque.peekFirst()] + " ");
            while (!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.pop();
            while (!deque.isEmpty() && input[i] >= input[deque.peekLast()])
                deque.pop();
            deque.add(i);
        }
        System.out.print(input[deque.peekFirst()]);
    }

    public static void main(String[] args) {
        int[] input = {10, 5, 2, 7, 8, 7};
        int k = 3;
        subArrayMax(input, k);
        System.out.println();
        subArrayMaxEfficient(input, k);
    }
}