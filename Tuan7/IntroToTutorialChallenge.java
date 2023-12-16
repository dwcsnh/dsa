package Tuan7;

import java.util.Scanner;

public class IntroToTutorialChallenge {
    public static int search(int[] a, int k, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] > k) {
                right = mid - 1;
            } else if (a[mid] < k) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();
        System.out.println(search(a, k, 0, n - 1));
    }
}
