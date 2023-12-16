package Tuan6;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
    }  

}

public class InsertionSortPart1 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        int key = arr[n - 1];
        boolean sorted = false;
        for (int i = n - 2; i >= -1; i--) {
            if (i == -1) {
                arr[i + 1] = key;
                sorted = true;
            } else {
               if (arr[i] > key) {
                arr[i + 1] = arr[i];
                } else {
                    arr[i + 1] = key;
                    sorted = true;
                } 
            }
            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
            if (sorted) {
                break;
            }
        }
        input.close();
    }
}

