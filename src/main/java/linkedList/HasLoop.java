package linkedList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HasLoop {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public Boolean hasLoop(Node node) {
        Node temp1 = node;
        Node temp2 = node;

        while(temp1 != null && temp2 != null) {
            temp1 = temp1.next;
            temp2 = temp2.next.next;
            if (temp1 == temp2) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testHasLoop() {
        Node node1 = new Node(1);
        Node node2= new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        HasLoop h = new HasLoop();

        System.out.print(h.hasLoop(node1));

        String[] a = {"a","b"};
        List list = new ArrayList();
        list.add("b");
        System.out.println(a[0]+" "+list.get(0));

    }
}
