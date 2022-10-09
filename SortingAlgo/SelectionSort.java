package SortingAlgo;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = { 4, -6,2,1,7};
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);    
        System.out.println(Arrays.toString(arr));
    }
    
    public static void insertionSort(int[] arr) {
        int size = arr.length;

        for(int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for(int j = i; j < size - 1; j++)  {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if(minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
