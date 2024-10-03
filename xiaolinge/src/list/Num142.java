package list;

public class Num142 {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            if (fast == slow) {
                break;
            }
        }
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }
}
