package Tuan3;

import java.util.Scanner;

public class SherlockAndArray {
    static String check(int[]a, int leftSum, int rightSum) {
        for (int i = 0; i < a.length; i++) {
            if (leftSum < rightSum) {
                leftSum += a[i];
                rightSum -= a[i + 1];
            } else if (leftSum == rightSum) {
                return "YES";
            } else {
                return "NO";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int n = input.nextInt();
            int[] a = new int[n];
            int leftSum = 0, rightSum = 0;
            for (int j = 0; j < n; j++) {
                a[j] = input.nextInt();
                rightSum += a[j];
            }
            rightSum -= a[0];
            System.out.println(check(a, leftSum, rightSum));
        }
        input.close();
    }
}
