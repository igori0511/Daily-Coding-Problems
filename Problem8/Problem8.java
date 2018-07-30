package com.design.patterns.factory.api;

/**
 * This problem was asked by Google.
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 * <p>
 * For example, the following tree has 5 unival subtrees:
 *   0
 *  / \
 * 1   0
 *    / \
 *   1   0
 *  / \
 * 1   1
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
}

public class Problem8 {

  private static int countUnivalSubtrees(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = countUnivalSubtrees(root.left);
    int right = countUnivalSubtrees(root.right);

    return isUnival(root) ? left + right + 1 : left + right;
  }

  private static boolean isUnival(TreeNode root) {
    return univalHelper(root, root.val);
  }

  private static boolean univalHelper(TreeNode root, int value) {
    return root == null || root.val == value && univalHelper(root.left, root.val) && univalHelper(root.right, root.val);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(0);
    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(0);
    root.right.left.left = new TreeNode(1);
    root.right.left.right = new TreeNode(1);
    System.out.println(Problem8.countUnivalSubtrees(root));
  }
}
