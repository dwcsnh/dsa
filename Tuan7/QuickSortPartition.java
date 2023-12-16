package Tuan7;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void partition(int[] a) {
        int n = a.length;
        int key = a[0];
        // int left = 0;
        // for (int i = 1; i < n; i++) {
        //     if (a[i] <= key) {
        //         int temp = a[++left];
        //         a[left] = a[i];
        //         a[i] = temp;
        //     }
        // }
        // int temp = a[left];
        // a[left] = a[0];
        // a[0] = temp;
        int i = 0, j = n;
        while (true) {
            while (a[++i] <= key) {
                if (i == n - 1) {
                    break;
                }
            }
            while (a[--j] > key) {
                if (j == 0) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int temp = a[0];
        a[0] = a[j];
        a[j] = temp;
    }

}

public class QuickSortPartition {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        Result.partition(a);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        input.close();
    }
}

