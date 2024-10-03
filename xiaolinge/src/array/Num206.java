package array;

/**
 * @author by asia
 * @Classname Num206
 * @Description Num206
 * @Date 2024/9/26 0:59
 */


public class Num206 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = sentinel.next;
            sentinel.next = next;
        }
        return sentinel.next;
    }

}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}