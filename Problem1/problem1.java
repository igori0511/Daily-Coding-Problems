package com.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * This problem was recently asked by Google.
 * <p>
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * <p>
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 */
public class Problem1 {

    private static boolean twoSum(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int complement = k - a[i];
            if (map.containsKey(complement)) {
                return true;
            }
            map.put(a[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 15, 3, 7};
        int k = 11;
        System.out.println(twoSum(array, k));

        int[] array2 = new int[]{};
        int k2 = 11;
        System.out.println(twoSum(array2, k2));

        int[] array3 = new int[]{11};
        int k3 = 11;
        System.out.println(twoSum(array3, k3));
    }
}