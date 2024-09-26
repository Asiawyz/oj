package array;

/**
 * @author by asia
 * @Classname Num203
 * @Description Num203
 * @Date 2024/9/26 13:54
 */
public class Num203 {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode tmp = sentinel;
        while (tmp.next != null) {
            ListNode next = tmp.next;
            if (next.val == val) {
                tmp.next = tmp.next.next;
            } else {
                tmp = next;
            }
        }
        return sentinel.next;
    }
}
