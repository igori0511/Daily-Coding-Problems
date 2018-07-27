package com.design.patterns.factory.api;

import java.util.Arrays;

/**
 * Given an array of integers, find the first missing positive integer in linear time and constant space. In other words,
 * find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 */
public class Problem4 {

  public static int solution(int[] nums) {

    if (nums.length == 0) return 1;


    for (int i = 0; i < nums.length; i++) {
      int v;
      while (i + 1 != nums[i] &&
        (0 < nums[i] && nums[i] <= nums.length)) {
        v = nums[i];
        nums[i] = nums[v - 1];
        nums[v - 1] = nums[i];
        nums[v - 1] = v;
        if (nums[i] == nums[v - 1])
          break;
      }
    }

    for (int i = 1, j = 0; i <= nums.length && j < nums.length; i++, j++) {
      if (nums[j] != i) return i;
    }

    return nums.length + 1;
  }

  public static void main(String[] args) {
    int[] a = new int[]{3, 4, -1, 1};

    System.out.println(solution(a));
    System.out.println(Arrays.toString(a));
  }
}
