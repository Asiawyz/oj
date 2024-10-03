package list;


public class Num24 {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode tmp = sentinel;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode left = tmp.next;
            ListNode right = left.next;
            left.next = right.next;
            tmp.next = right;
            right.next = left;
            tmp = left;
        }
        return sentinel.next;
    }
}

