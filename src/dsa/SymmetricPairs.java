package dsa;

import java.util.*;

public class SymmetricPairs {
    public static void symmetricPair(int[][] arr) {
        int n = arr.length;
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap();
        LinkedHashMap<Integer, Integer> unique = new LinkedHashMap();
        for(int i=0; i<n; i++){
            int key = arr[i][0];
            int value = arr[i][1];
            if(map.containsKey(value) && map.get(value) == key){
                System.out.println(value +" "+ key);
            } else {
                map.put(key, value);
            }
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int arr[][] = new int[row][2];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < 2 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        symmetricPair(arr);
    }
}
