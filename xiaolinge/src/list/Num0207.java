package list;

import java.util.ArrayDeque;
import java.util.Deque;

public class Num0207 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headB == null || headA == null) {
            return null;
        }
        Deque<ListNode> stackA = new ArrayDeque<>();
        Deque<ListNode> stackB = new ArrayDeque<>();
        ListNode tmp = headA;
        while (tmp != null) {
            stackA.addLast(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            stackB.addLast(tmp);
            tmp = tmp.next;
        }
        ListNode ans = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            ListNode nodeA = stackA.removeLast();
            ListNode nodeB = stackB.removeLast();
            if (nodeA == nodeB) {
                ans = nodeA;
            } else {
                break;
            }
        }
        return ans;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null || pB != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return null;
    }
}
