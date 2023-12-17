package Tuan11;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTheRunningMedian {
    static PriorityQueue<Double> minPQ;
    static PriorityQueue<Double> maxPQ;

    public static void add(double x) {
        if (maxPQ.isEmpty() || x <= maxPQ.peek()) {
            maxPQ.add(x);
        } else {
            minPQ.add(x);
        }
        balancingSize();
    }

    public static void getMid(int size) {
        if (size % 2 == 0) {
            String formattedNumber = String.format("%.1f", (minPQ.peek() + maxPQ.peek()) / 2);
            System.out.println(formattedNumber);
        } else {
            String formattedNumber = String.format("%.1f", maxPQ.peek());
            System.out.println(formattedNumber);
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
        double x;
        for (int i = 1; i <= n; i++) {
            x = input.nextInt();
            add(x);
            getMid(i);
        }
        input.close();
    }
}
