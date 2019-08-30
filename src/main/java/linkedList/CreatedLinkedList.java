package linkedList;

import org.junit.Test;

public class CreatedLinkedList {

    private Node head;
    private Node current;
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            current = head;
        } else {
            current.next = new Node(data);
            current = current.next;
        }
    }

    public void print(Node node) {
        current = node;
        while(current != null) {
            System.out.print(current.data+"->");
            current = current.next;
        }
    }

    @Test
    public void testCreatedLinkedList() {
        CreatedLinkedList linkedList = new CreatedLinkedList();

        for(int i=1;i<8;i++) {
            linkedList.add(i);
        }
        linkedList.print(linkedList.head);
    }
}
