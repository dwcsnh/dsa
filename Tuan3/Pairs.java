package Tuan3;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs {
    public static int BinarySearch(int[] arr, int key, int left, int right) {
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > key) {
                right = mid - 1;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int count = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
            int key = array[i] + k;
            int result = BinarySearch(array, key, i, n - 1);
            if (result != -1) {
                count++;
            }
        }
        input.close();
        System.out.println(count);
    }
}

