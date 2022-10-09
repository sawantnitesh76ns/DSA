package SortingAlgo;

import java.util.Arrays;

public class QuickSort {
    
    public static int getPivot(int[] arr, int low, int high) {
        int i = low - 1;
        int pivot = arr[high];

        for(int j = low; j < high; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;

    }


    public static void quickSort(int[] arr , int low , int high) {
        if(low < high) {
            int piv = getPivot(arr, low, high);
            quickSort(arr, low, piv - 1);
            quickSort(arr, piv + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4,7,2,9,12,5,8};
        System.out.println(Arrays.toString(arr));
        String temp = "dwqddd";
        temp.contains("temp");
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
