import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This problem was asked by Facebook.
 * <p>
 * You are given an array of non-negative integers that represents a two-dimensional
 * elevation map where each element is unit-width wall and the integer is the height.
 * Suppose it will rain and all spots between two walls get filled up.
 * <p>
 * Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
 * <p>
 * For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.
 * <p>
 * Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second,
 * and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
 */
public class Solution30 {

    public static int trappedWater(List<Integer> elevationMap) {

        if (elevationMap.size() == 0) return 0;

        int total = 0;
        int max_i = elevationMap.indexOf(Collections.max(elevationMap));
        int left_max = elevationMap.get(0);

        for (int i = 1; i < max_i; i++) {
            int num = elevationMap.get(i);
            total += left_max - num;
            left_max = Integer.max(left_max, num);
        }

        int endIndex = elevationMap.size() - 1;
        int rightMax = elevationMap.get(endIndex);

        for (int i = endIndex - 1; i > max_i; i--) {
            int num = elevationMap.get(i);
            total += rightMax - num;
            rightMax = Integer.max(rightMax, num);
        }

        return total;
    }

    public static void main(String[] args) {
        Integer[] elevationMapArray = {3, 0, 1, 3, 0, 5};
        List<Integer> elevationMap = Arrays.asList(elevationMapArray);
        System.out.println(trappedWater(elevationMap));
    }
}