package SortingAlgo;

import java.util.Arrays;

public class MergeSort {
    
    public static void merge(int[] arr, int l, int m, int r) {
        // get size of both array
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] A = new int[n1];
        int[] B = new int[n2];

        // fill these arrays
        for(int i = 0;i < n1; i++) {
            A[i] = arr[l + i];
        }
        for(int j = 0; j < n2; j++) {
            B[j] = arr[m + 1 + j];
        }

        // declare initiale indexes
        int i = 0;
        int j = 0;
        int k = l;

        while(i < n1 && j < n2) {
            if(A[i] <= B[j]) {
                arr[k] = A[i];
                i++;
            } else {
                arr[k] = B[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = A[i];
            i++;
            k++;
        }
        
        while(j < n2) {
            arr[k] = B[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int l, int r)  {
        if(l < r) {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,6,2,7,1,9,10};
       System.out.println( Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println( Arrays.toString(arr));
    }
}
