package com.interview;

import java.util.Stack;

/**
 * This problem was asked by Google.
 * <p>
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s),
 * which deserializes the string back into the tree
 */

class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Codec {

    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder serializedBt = new StringBuilder();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                serializedBt.append(node.val).append(",");
                stack.push(node.right);
                stack.push(node.left);
            } else {
                serializedBt.append("#,");
            }
        }

        return serializedBt.toString().substring(0, serializedBt.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;

        index = 0;
        String[] serializedBt = data.split(",");
        return deserialize(serializedBt);
    }

    private TreeNode deserialize(String[] serializedBt) {

        if (index == serializedBt.length || serializedBt[index].equals("#")) {
            ++index;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(serializedBt[index++]));
        root.left = deserialize(serializedBt);
        root.right = deserialize(serializedBt);

        return root;
    }

    public static void main(String[] args) {
        // create codec
        Codec treeSerializer = new Codec();
        // create a sample tree
        TreeNode rootNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(5);
        rootNode.left = leftNode;
        rootNode.right = rightNode;

        String serializedTree = treeSerializer.serialize(rootNode);
        System.out.println(serializedTree);
        TreeNode deserializedTree = treeSerializer.deserialize(serializedTree);
        System.out.println(serializedTree.equals(treeSerializer.serialize(deserializedTree)));
    }
}