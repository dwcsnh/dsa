package bonus;

import java.util.Scanner;
import java.util.PriorityQueue;

public class Gift {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            minPQ.add(x);
            if (i < k) {
                sum += x;
                System.out.print(sum + " ");
            } else {
                sum = sum - minPQ.poll() + x;
                System.out.print(sum + " ");
            }
        }
        input.close();
    }
}

