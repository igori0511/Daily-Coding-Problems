package com.design.patterns.decorator.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

  private TrieNode root;

  class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
    String word;
  }

  /**
   * Initialize your data structure here.
   */
  public Trie() {
    root = new TrieNode();
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    TrieNode cur = root;
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      sb.append(c);
      if (!cur.children.containsKey(c)) {
        cur.children.put(c, new TrieNode());
      }
      cur = cur.children.get(c);
    }
    cur.word = sb.toString();
    cur.isEnd = true;
  }

  /**
   * Returns List if there is any word in the trie that starts with the given prefix.
   */
  public Collection<String> autoComplete(String prefix) {
    TrieNode cur = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (cur.children.containsKey(c)) {
        cur = cur.children.get(c);
      } else {
        return Collections.emptyList();
      }
    }
    return allPrefixes(cur);
  }

  private Collection<String> allPrefixes(TrieNode prefixStart) {
    List<String> results = new ArrayList<>();
    if (prefixStart.isEnd) {
      results.add(prefixStart.word);
    }
    for (Map.Entry<Character, TrieNode> entry : prefixStart.children.entrySet()) {
      TrieNode child = entry.getValue();
      Collection<String> childPrefixes = allPrefixes(child);
      results.addAll(childPrefixes);
    }
    return results;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("dog");
    trie.insert("deer");
    trie.insert("deal");
    System.out.println(trie.autoComplete("de"));
  }
}





