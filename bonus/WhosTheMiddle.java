package bonus;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class WhosTheMiddle {
    static PriorityQueue<Integer> minPQ;
    static PriorityQueue<Integer> maxPQ;

    public static void add(int x) {
        if (maxPQ.isEmpty() || x <= maxPQ.peek()) {
            maxPQ.add(x);
        } else {
            minPQ.add(x);
        }
        balancingSize();
    }

    public static void getMid() {
        if (!maxPQ.isEmpty()) {
            System.out.println(maxPQ.peek());
        } else {
            System.out.println(0);
        }
    }

    public static void balancingSize() {
        if (maxPQ.size() > minPQ.size() + 1) {
            minPQ.add(maxPQ.poll());
        } else if (minPQ.size() > maxPQ.size()) {
            maxPQ.add(minPQ.poll());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        int n = input.nextInt();
        int m = input.nextInt();
        int x, type;
        for (int i = 0; i < n; i++) {
            x = input.nextInt();
            add(x);
        }
        for (int i = 0; i < m; i++) {
            type = input.nextInt();
            if (type == 1) {
                x = input.nextInt();
                add(x);
            } else if (type == 2) {
                maxPQ.poll();
                balancingSize();
            } else {
                getMid();
            }
        }
        input.close();
    }
}

