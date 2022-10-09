package LinkedList;

public class DoublyLL {
    Node head;
    Node tail;

    static class Node {
        int val;
        Node next;
        Node prev;

        Node(int _val) {
            val = _val;
            next = null;
            prev = null;
        }
    }

    void inserNode(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    int delTail() {
        Node headRef = head;
        while(headRef.next != null) {
            headRef = headRef.next;
        }
        
        if(headRef.prev == null) {
            head = null;
            tail = null;
        } else {
            tail = headRef.prev;
            tail.next  = null;
        }

        return headRef.val;
    }

    void printLL() {
        Node headRef = head;
        while(headRef != null) {
            System.out.println(headRef.val);
            headRef = headRef.next;
        }
    }

    public static void main(String[] args) {
        DoublyLL doublyLL = new DoublyLL();
        doublyLL.inserNode(1);
        doublyLL.printLL();
        doublyLL.delTail();
        System.out.println("================");
        doublyLL.inserNode(2);
        doublyLL.inserNode(3);
        doublyLL.inserNode(4);
        doublyLL.inserNode(5);       
        doublyLL.printLL(); 
        
    }
}
