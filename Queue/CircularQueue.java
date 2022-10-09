package Queue;

import java.util.PriorityQueue;

public class CircularQueue {
    int f;
    int r;
    int SIZE;
    int[] arr;

    CircularQueue(int arrSize) {
        SIZE = arrSize;
        arr = new int[arrSize];
        f = -1;
        r = -1;
    }

    boolean isEmpty() {
        return f == -1;
    }

    boolean isFull() {
        if(f == 0 && r == SIZE - 1) {
            return true;
        } else if(f == r + 1) {
            return true;
        }

        return false;
    }

    void enQueue(int val) {
        if(isFull()) {
            System.err.println("Queue is full");
            System.exit(-1);
        } else {
            if(f == -1) {
                f = 0;
            }

            r = r + 1 % SIZE;
            arr[r] = val;
        }
    }

    int deQueue() {
        int element;
        if(isEmpty()) {
            System.err.println("Queue is empty");
            System.exit(-1);
            return (-1);
        }
        else {
            element = arr[f];
            if(f == r) {
                f = -1;
                r = -1;
            }

            f = f + 1 % SIZE;
            return element;
        }
    }

    void printQueue() {
        if(isEmpty()) {
            System.err.println("Queue is empty");
            System.exit(-1);
        } else {
            for(int i = f; i <= r; i++) {
                System.out.println(arr[i]);
            }
        }
    }


    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        circularQueue.enQueue(5);

        circularQueue.printQueue();

        circularQueue.deQueue();

        circularQueue.printQueue();
    }
}