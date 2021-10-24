package dsa;

import java.util.*;

public class NearlySortedArray {
    private static void sortArray(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue();

        for(int i=0; i<=k; i++){
            q.add(arr[i]);
        }

        int j = 0;
        for(int i=k+1; i<arr.length && !q.isEmpty(); i++){
            arr[j] = q.remove();
            q.add(arr[i]);
            j++;
        }

        while(!q.isEmpty()){
            arr[j] = q.remove();
            j++;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sortArray(arr, k);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
