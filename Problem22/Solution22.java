package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This problem was asked by Microsoft.
 * <p>
 * Given a dictionary of words and a string made up of those words (no spaces),
 * return the original sentence in a list. If there is more than one possible reconstruction,
 * return any of them. If there is no possible reconstruction, then return null.
 * <p>
 * For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string
 * "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].
 * <p>
 * Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string
 * "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
public class Solution22 {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> dp = new HashMap<>();
        int max = 0;
        for (String s1 : wordDict) {
            max = Math.max(max, s1.length());
        }
        return wordBreakUtil(s, wordDict, dp, 0, max);
    }

    private static List<String> wordBreakUtil(String s, List<String> dict, Map<Integer, List<String>> dp, int start, int max) {
        if (start == s.length()) {
            return Collections.singletonList("");
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        List<String> words = new ArrayList<>();
        for (int i = start; i < start + max && i < s.length(); i++) {
            String newWord = s.substring(start, i + 1);
            if (!dict.contains(newWord)) {
                continue;
            }
            List<String> result = wordBreakUtil(s, dict, dp, i + 1, max);
            for (String word : result) {
                String extraSpace = word.length() == 0 ? "" : " ";
                words.add(newWord + extraSpace + word);
            }
        }
        dp.put(start, words);
        return words;
    }


    public static void main(String[] args) {
        String words = "bedbathandbeyond";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("bed");
        dictionary.add("bath");
        dictionary.add("bedbath");
        dictionary.add("and");
        dictionary.add("beyond");
        System.out.println(wordBreak(words, dictionary));
    }
}