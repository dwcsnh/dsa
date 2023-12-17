package Tuan11;

import java.util.HashSet;
import java.util.Scanner;

public class PairUsingHash {
    public static int countPairsWithDifference(int[] a, int k) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for (int num : a) {
            set.add(num);
        }

        for (int num : a) {
            if (set.contains(num + k)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        input.close();
        System.out.println(countPairsWithDifference(a, k));
    }
}
