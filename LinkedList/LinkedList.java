package LinkedList;




public class LinkedList {
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

    void inserNode(int val) {
        if(head == null) {
            head = new Node(val);
            tail = head;
        } else {
            Node newNode = new Node(val);
            tail.next = newNode;
            tail = newNode;
        }
    }

    int removeTail() {
        if(head == null) {
            System.err.println("Linked list is empty");
            return(-1);
        } else {
            Node node = head;
            Node prev = null;
            while(node.next != null) {
                prev = node;
                node = node.next;
            }

            prev.next = null;
            tail = prev;

            return(node.val);
        }
    }

    void linkedListTraversal() {
        Node node = head;
        while(node != null) {
            System.out.println("Node value --->" + node.val);
            node = node.next;
        }
    }   

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.inserNode(1);
        linkedList.inserNode(2);
        linkedList.inserNode(3);
        linkedList.inserNode(4);

        linkedList.linkedListTraversal();

        linkedList.removeTail();
        linkedList.linkedListTraversal();

    }

}
