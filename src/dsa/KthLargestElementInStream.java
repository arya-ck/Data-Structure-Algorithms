package dsa;

import java.util.*;

public class KthLargestElementInStream {

    public static void insertAtPosition(int[] arr, int size, int n){
        // insert n at the correct position in the sorted array from index 0 to size-1
        // System.out.println("Before sorting "+Arrays.toString(arr));
        int i = size;
        while(i>0 && arr[i-1]>n){
            arr[i] = arr[i-1];
            i--;
        }

        arr[i] = n;
        // System.out.println("After sorting "+Arrays.toString(arr));
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int stream[] = new int[n];

        for (int i = 0; i < n; i++) {
            stream[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            insertAtPosition(stream, i, stream[i]);
            // check if k >0 and i >= k-1
            if(i >= k-1 && k>0){
                System.out.println(k+" largest number is "+stream[i-k+1]);
            } else {
                System.out.println("None");
            }
        }
    }
}