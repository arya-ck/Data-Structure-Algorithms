package dsa;

import java.util.*;

public class SearchKRotatedArray {
    public static int search(int arr[], int left, int right, int key) {
        if(left>right){
            return -1;
        }

        int mid = (left+right) /2;

        if(arr[mid] == key){
            return mid;
        } else if(arr[mid]>arr[right]){
            if(key<arr[left] || key>arr[mid]){
                return search(arr, mid+1, right, key);
            } else {
                return search(arr, left, mid-1, key);
            }
        } else if(arr[mid]<arr[left]){
            if(key<=arr[right]){
                return search(arr, mid+1, right, key);
            } else {
                return search(arr, left, mid-1, key);
            }
        } else {
            if(key>=arr[mid]){
                return search(arr, mid+1, right, key);
            } else {
                return search(arr, left, mid-1, key);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int i = search(arr, 0, n - 1, key);
        if (i != -1) {
            System.out.println(i);
        } else {
            System.out.println("-1");
        }
    }
}
