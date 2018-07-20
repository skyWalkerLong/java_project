package arithmetic.le;

import org.junit.Test;

/**
 * 快慢指针判断单链表是否有环。一次遍历找单链表的中间值也是用这种方法。
 * @author longchao
 * @date 2018/7/20.
 */
public class LinkedlistCycle_141 {

    class Node {
        Node next;
        int data;
        Node(int data) {
            this.data = data;
        }
    }
    public Boolean hasLoop(Node head) {
        if (head == null) return false;
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }

        return false;

    }

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(2);
        Node node5 = new Node(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;
        System.out.println(hasLoop(node1));

    }
}
