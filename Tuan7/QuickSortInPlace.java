package Tuan7;

import java.util.*;

public class QuickSortInPlace {
    public static int partition(int[] a, int left, int right) {
        int i = left - 1;
        int x = a[right];
        for (int j = left; j < right; j++) {
            if (a[j] <= x) {
                int temp = a[++i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[++i];
        a[i] = a[right];
        a[right] = temp;
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
        return i;
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int left, int right) {
        if (left < right) {
            int p = partition(a, left, right);
            sort(a, left, p - 1);
            sort(a, p + 1, right);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        sort(a);
        input.close();
    }
}

