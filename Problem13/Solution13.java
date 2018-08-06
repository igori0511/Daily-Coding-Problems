import java.util.HashMap;
import java.util.Map;

/**
 * This problem was asked by Amazon.
 * <p>
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
 * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
public class Solution13 {
    public static String kAtMostDistinct(String s, int k) {
        int start = 0, end = 0, windowSize = 1, windowStart = 0, size = s.length();
        char[] stringChars = s.toCharArray();
        Map<Character, Integer> charCount = new HashMap<Character, Integer>() {{
            put(stringChars[0], 1);
        }};

        for (int i = 1; i < size; i++) {
            if (!charCount.containsKey(stringChars[i])) {
                charCount.put(stringChars[i], 1);
            } else {
                charCount.put(stringChars[i], charCount.get(stringChars[i]) + 1);
            }
            end++;

            int uniqueCharCount = 0;

            for(Map.Entry<Character, Integer> entry: charCount.entrySet()) {
                if (entry.getValue() != 0) {
                    uniqueCharCount++;
                }
            }

            while(uniqueCharCount > k) {
                charCount.put(stringChars[start], charCount.get(stringChars[start]) - 1);
                uniqueCharCount--;
                start++;
            }

            int currentWindowsSize = end - start + 1;
            if (currentWindowsSize > windowSize) {
                windowSize = currentWindowsSize;
                windowStart = start;
            }
        }

        return s.substring(windowStart, windowStart + windowSize);
    }

    public static void main(String[] args) {
        String s = "abcba";
        int k = 2;
        System.out.println(Solution13.kAtMostDistinct(s, k));
    }
}