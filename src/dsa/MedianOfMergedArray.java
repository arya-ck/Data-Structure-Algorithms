package dsa;

import java.util.*;

public class MedianOfMergedArray {
    public static int median(int[] arr1, int[] arr2 , int n){

        if(n==0){
            return 0;
        }
        int merged[] = new int[2*n];

        int i =0, j =0, k =0;

        // add smaller element from either array to merged array
        while(j<n && i<n){
            if(arr1[i]<arr2[j]){
                merged[k] = arr1[i];
                i++; k++;
            } else {
                merged[k] = arr2[j];
                j++; k++;
            }
        }

        // add remaining elements of arr1 if any
        while(i<n){
            merged[k] = arr1[i];
            i++; k++;
        }

        // add remaining elements of arr2 if any
        while(j<n){
            merged[k] = arr2[j];
            j++; k++;
        }
        // return average of middle elements
        return (merged[k/2] + merged[k/2-1])/2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr1[] = new int[n];
        int arr2[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr1[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println(median(arr1, arr2, n));
    }
}
