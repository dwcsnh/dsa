package Tuan3;

import java.util.Scanner;

public class NewYearChaos {
    public static void minimumBribes(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] - i - 1 > 2) {
                ans = -1;
                break;
            } else {
                for (int j = Math.max(0, arr[i] - 3); j < i; j++) {
                    if (arr[j] > arr[i]) {
                        ans++;
                    }
                }
            }
        }
        if (ans == -1) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = input.nextInt();
            }
            minimumBribes(array);
        }
        input.close();
    }
}