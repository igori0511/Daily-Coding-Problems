package com.interview;

import java.util.Arrays;

/**
 * This problem was asked by Facebook.
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class Solution7 {
    public static int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] decodeWays = new int[s.length() + 2];
        Arrays.fill(decodeWays, 1);
        int i = s.length() - 1;

        decodeWays[i] = s.charAt(i) == '0' ? 0 : 1;

        for (i = i - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                decodeWays[i] = 0;
            } else {
                decodeWays[i] = decodeWays[i + 1];
                if (i + 2 < decodeWays.length && s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6') {
                    decodeWays[i] += decodeWays[i + 2];
                }
            }
        }

        return decodeWays[0];
    }

    public static void main(String[] args) {
        String s = "111";
        System.out.println(Solution7.numDecodings(s));
    }
}