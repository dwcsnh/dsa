package Tuan7;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int partition(int[] a, int left, int right) {
        int i = left - 1;
        int key = a[right];
        for (int j = left; j < right; j++) {
            if (a[j] <= key) {
                int temp = a[++i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[++i];
        a[i] = a[right];
        a[right] = temp;
        return i;
    }

    public static void sort(int[] a) {
        int n = a.length;
        sort(a, 0, n - 1);
    }

    public static void sort(int[] a, int left, int right) {
        if (left < right) {
            int p = partition(a, left, right);
            sort(a, left, p - 1);
            sort(a, p + 1, right);
        }
    }
    
    public static int findMedian(int[] a) {
        int n = a.length;
        return a[n / 2];
    }
}

public class FindTheMedian {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        Result.sort(a);
        System.out.println(Result.findMedian(a));
        input.close();
    }
}

