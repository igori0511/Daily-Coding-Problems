import java.util.HashSet;
import java.util.Set;

/**
 * This problem was asked by Google.
 * <p>
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 * For example, given
 * A = 3 -> 7 -> 8 -> 10 and
 * B = 99 -> 1 -> 8 -> 10,
 * return the node with value 8.
 * In this example, assume nodes with the same value are the exact same node objects.
 */

public class Solution20 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode intersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();

        while (headA != null) {
            nodeSet.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodeSet.contains(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }
}