package arithmetic.le;

import org.junit.Test;

/**
 * 单链表有环找入口，根据推断，当fast和slow节点相遇时，head到入口的距离等于slow和fast节点到入口的距离
 * 推到过程见 https://www.cnblogs.com/ganganloveu/p/3715981.html
 *
 * @author longchao
 * @date 2018/7/20.
 */
public class LinkedlistCycle_142 {

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public Node hasLoop(Node head) {

        if (head == null) return null;

        Node fast = head;
        Node slow = head;
        Boolean hasLoop = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasLoop = true;
                break;
            }
        }

        if (hasLoop) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        return null;

    }

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        System.out.println(hasLoop(node1).data);

    }
}
