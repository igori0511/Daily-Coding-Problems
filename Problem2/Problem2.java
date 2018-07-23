package com.interview;

import java.util.Arrays;

/**
 * This problem was asked by Uber.
 * <p>
 * Given an array of integers, return a new array such that each element at index i
 * of the new array is the product of all the numbers in the original array except the one at i.
 * <p>
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
public class Problem2 {

    private static int[] calculateProductExceptSelfBruteForce(int[] nums) {
        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) prod *= nums[j];
            }
            output[i] = prod;
        }

        return output;
    }

    private static int[] calculateProductExceptSelfEfficient(int[] nums) {
        int length = nums.length;
        int left[] = new int[length];
        int right[] = new int[length];
        int prod[] = new int[length];

        int i, j;
        left[0] = 1;
        right[length - 1] = 1;

        for (i = 1; i < length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        for (j = length - 2; j >= 0; j--) {
            right[j] = nums[j + 1] * right[j + 1];
        }

        for (i = 0; i < length; i++) {
            prod[i] = left[i] * right[i];
        }

        return prod;
    }

    // works if the product array doesn't contain zeroes
    private static int[] calculateProductExceptSelfElegant(int[] nums) {
        int length = nums.length;

        int product = 1;
        int temp = nums[0];
        int[] output = new int[length];

        for (int num : nums) {
            product *= num;
        }

        output[0] = product;
        for (int i = 1; i < length; i++) {
            output[i] = (product / nums[i]) * temp;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(calculateProductExceptSelfBruteForce(array)));
        System.out.println(Arrays.toString(calculateProductExceptSelfEfficient(array)));
        System.out.println(Arrays.toString(calculateProductExceptSelfElegant(array)));
    }
}