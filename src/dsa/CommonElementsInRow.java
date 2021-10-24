package dsa;

import java.util.*;

public class CommonElementsInRow {
    public static void printElementInAllRows(int mat[][]) {

        TreeMap<Integer, Integer> map = new TreeMap();
        int m = mat.length;
        int n = m>0? mat[0].length: 0;

        // Initialize map with elements of first row
        for(int j=0; j<n; j++){
            if(map.containsKey(mat[0][j])){
                map.put(mat[0][j], map.get(mat[0][j])+1);
            } else {
                map.put(mat[0][j], 1);
            }
        }

        // Iterate over the array
        for(int i=1; i<m; i++){

            HashMap<Integer, Integer> rowMap = new HashMap();
            List<Integer> del = new LinkedList();

            // identify elements of each row
            for(int j=0; j<n; j++){
                if(rowMap.containsKey(mat[i][j])){
                    rowMap.put(mat[i][j], rowMap.get(mat[i][j])+1);
                } else {
                    rowMap.put(mat[i][j], 1);
                }
            }

            //
            for(Integer key: map.keySet()){
                // if an element is in row data and map, check the count
                if(rowMap.containsKey(key)){
                    int count = rowMap.get(key);

                    // update count when row data has fewer elements of same value
                    if(count < map.get(key)){
                        map.put(key, count);
                    }
                } else {
                    // if the element present in row is map in row, remove it
                    del.add(key);
                }
            }

            // remove elements from map, which are not in row
            for(Integer key: del){
                map.remove(key);
            }
        }

        // display elements which are present in all rows
        for(Integer key: map.keySet()){
            int count = map.get(key);

            for(int i=0; i< count; i++){
                System.out.print(key+" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int matrix[][] = new int[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        printElementInAllRows(matrix);
    }
}
