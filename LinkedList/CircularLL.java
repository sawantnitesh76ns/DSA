package LinkedList;

public class CircularLL {
    Node head;
    Node tail;

    static class Node {
        int val;
        Node next;

        Node(int _val) {
            val = _val;
            next = null;
        }
    }


    void insertNode(int _val) {
        Node newNode = new Node(_val);
        if(head == null) {
            head = newNode;
            tail = head;
            newNode.next = tail;
        } else {
            
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }


    void traversalLL() {
        if(head == null) {
            System.err.println("LL is empty");
        }
        else {
            Node headNodeRef = head;

            do {
                System.out.println(headNodeRef.val);
            } while(headNodeRef != head);

            // System.out.println(headNodeRef.val);
        }
    }

    public static void main(String[] args) {
        CircularLL doublyLinkedList = new CircularLL();
        doublyLinkedList.insertNode(1);
        doublyLinkedList.traversalLL();
        doublyLinkedList.insertNode(2);
        doublyLinkedList.insertNode(3);
        doublyLinkedList.traversalLL();
    }
}
