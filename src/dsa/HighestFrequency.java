package dsa;

import java.util.*;

public class HighestFrequency {

    public static int mostFrequentElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        int n = arr.length;

        // return -1 when Array is empty
        if(n==0){
            return -1;
        }

        for(int i=0; i<n; i++){
            int num = arr[i];

            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1); // increment count
            } else {
                map.put(num, 1); // initialize count
            }
        }

        // create list of Map entries
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());

        // Sort list by count in descending order
        Collections.sort(list, (Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) -> b.getValue().compareTo(a.getValue()));

        // return number with max count
        Map.Entry<Integer, Integer> maxEntry = list.get(0);
        return maxEntry.getKey();
    }


    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(mostFrequentElement(arr));
    }
}