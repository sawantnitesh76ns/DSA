package SortingAlgo;

public class BubbleSort {
    
    public static void main(String[] args) {
        int[] arr = {9,3,5,2,1,3,5};
        printArr(arr);
        System.out.println();
        int[] reult = bubbleSort(arr);
        printArr(reult);

    }

    public static int[] bubbleSort(int[] arr) {

        for(int i = 0; i < arr.length; i++) {
            boolean sorted = false;
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    sorted = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

                
            }
            if(!sorted) {
                break;
            }
        }
        return arr;
    }

    public static void printArr(int[] arr) {
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }
}
