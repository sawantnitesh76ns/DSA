package SortingAlgo;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    int[] arr = { 5, 3, 7, 9, 1 };
    System.out.println(Arrays.toString(arr));
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] arr) {
    int size = arr.length;

    for (int i = 0; i < size - 1; i++) {
      int buffIndex = i + 1;
      int buffElment = arr[i + 1];

      for (int j = i; j >= 0; j--) {
        if (arr[j] > buffElment) {
          arr[buffIndex] = arr[j];
          buffIndex = j;
        }
      }

      arr[buffIndex] = buffElment;
    }
  }
}
