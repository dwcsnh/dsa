package Tuan6;

import java.io.*;
import java.util.*;

public class CountingSort {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int[] count = new int[100];
        for (int i = 0; i < 100; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            count[a[i]]++;
        }
        for (int i = 0; i < 100; i++) {
            System.out.print(count[i] + " ");
        }
        input.close();
    }
}
