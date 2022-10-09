package Queue;
import java.util.*;

public class PriorityQueue {
    
    // Heapify a given heap tree

    void heapify(ArrayList<Integer> arr , int i) {
        int size = arr.size();
        int largest = i;
        int left = i * 2 + 1;
        int right  = i * 2 + 2;

        if( left < size && arr.get(left) > arr.get(largest)) {
            largest = left;
        }
        if(right < size && arr.get(right) > arr.get(largest)) {
            largest = right;
        }

        if(largest != i) {
            int temp = arr.get(largest);
            arr.set(largest, arr.get(i));
            arr.set(i, temp);

            heapify(arr, largest);
        }
    }


    void inserNode(ArrayList<Integer> arr , int val) {
        int size = arr.size();

        if(size == 0) {
            arr.add(val);
        } else {
            arr.add(val);

            // heapify arr
            for(int i = size / 2 - 1; i >= 0; i--) {
                heapify(arr, i);
            }
        }
    }

    HashMap

    void deleteNode(ArrayList<Integer> arr , int num) {
        int size = arr.size();
        int i;
        for(i = 0; i < size; i++) {
            if(arr.get(i) == num) {
                break;
            }
        }

        // swap with number at last index
        int temp = arr.get(size - 1);
        arr.set(size - 1 , arr.get(i));
        arr.set(i , temp);
        
        // remove last element
        arr.remove(size - 1);   

        // Heapify half of the heap
        for(int j = size / 2 - 1; j >= 0; j--) {
            heapify(arr , j);
        }
    }

    void printArray(ArrayList<Integer> arr) {
        System.out.println("=============================");
        for(int num : arr) {
            System.out.println(num);
        }
    }


    public static void main(String[] args) {
        PriorityQueue  priorityQueue = new PriorityQueue();

        ArrayList<Integer> arr = new ArrayList<>();

        priorityQueue.inserNode(arr, 3);
        priorityQueue.inserNode(arr, 4);
        priorityQueue.inserNode(arr, 9);
        priorityQueue.inserNode(arr, 1);
        priorityQueue.inserNode(arr, 2);

        priorityQueue.printArray(arr);

        priorityQueue.deleteNode(arr, 3);

        priorityQueue.printArray(arr);

    }

}
