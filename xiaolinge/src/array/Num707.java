package array;

/**
 * @author by asia
 * @Classname Num707
 * @Description Num707
 * @Date 2024/9/26 14:02
 */
public class Num707 {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        System.out.println(list.get(0));
        list.addAtIndex(1,2);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list.get(1));
    }

}

class MyLinkedList {

    int size;

    Node dHead;

    Node dTail;

    public MyLinkedList() {
        size = 0;
        dTail = new Node(-99);
        dHead = new Node(-1);
        dHead.next = dTail;
        dTail.prev = dHead;
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node tmp = dHead.next;
        while (index > 0) {
            tmp = tmp.next;
            --index;
        }
        return tmp.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.prev = dHead;
        node.next = dHead.next;
        node.next.prev = node;
        dHead.next = node;
        ++size;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        node.prev = dTail.prev;
        node.next = dTail;
        node.prev.next = node;
        dTail.prev = node;
        ++size;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index > size) {
            return;
        }
        Node tmp = dHead.next;
        while (index > 0) {
            tmp = tmp.next;
            --index;
        }
        Node node = new Node(val);
        node.next = tmp;
        node.prev = tmp.prev;
        tmp.prev = node;
        node.prev.next = node;
        ++size;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }
        Node tmp = dHead.next;
        while (index > 0) {
            tmp = tmp.next;
            --index;
        }
        tmp.prev.next = tmp.next;
        tmp.next.prev = tmp.prev;
        --size;
    }

    static class Node {
        int val;
        Node prev, next;

        Node() {}

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}

