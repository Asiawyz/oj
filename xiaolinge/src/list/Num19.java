package list;

public class Num19 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head = new Num19().removeNthFromEnd(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        int len = 0;
        ListNode tmp = sentinel;
        while (tmp.next != null) {
            tmp = tmp.next;
            ++len;
        }
        int index = len - n + 1;
        int i = 0;
        tmp = sentinel;
        while (i != index) {
            ListNode next = tmp.next;
            ++i;
            if (i == index) {
                tmp.next = next.next;
                break;
            }
            tmp = next;
        }
        return sentinel.next;
    }



}
