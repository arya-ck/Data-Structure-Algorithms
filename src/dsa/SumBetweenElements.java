package dsa;

import java.util.*;

public class SumBetweenElements {
    public static int sumBetweenPthToQthSmallestElement(int[] arr, int p, int q) {

        if(p<=0 || q<=0){
            return -1;
        }

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // find the pth and qth smallest elements
        int pEl = sorted[p-1];
        int qEl = sorted[q-1];
        int n = arr.length;
        int sum = 0;

        // find sum
        for(int i=0; i<n; i++){
            if(arr[i]>pEl && arr[i]<qEl){
                sum += arr[i];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println(sumBetweenPthToQthSmallestElement(arr, p, q));
    }
}
