package bonus;

import java.util.PriorityQueue;
import java.util.Scanner;

public class StartUp {
    public static class Entry implements Comparable<Entry> {
        int position;
        int value;

        public Entry (int pos, int val) {
            position = pos;
            value = val;
        }

        @Override
        public int compareTo(Entry e) {
            return Integer.compare(this.value, e.value);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N, x, u, v;
        PriorityQueue<Entry> priorityQueue = new PriorityQueue<>();
        N = input.nextInt();
        for (int i = 1; i < N; i++) {
            x = input.nextInt();
            if (x == 1) {
                u = input.nextInt();
                priorityQueue.add(new Entry(i, u));
            } else {
                v = input.nextInt();
                if (v <= priorityQueue.size()) {
                    int size = priorityQueue.size();
                    for (int j = 0; j <= size - v; j++) {
                        priorityQueue.poll();
                    }
                }
            }
        }
        x = input.nextInt();
        v = input.nextInt();
        if (v <= priorityQueue.size()) {
            long sum = 0;
            PriorityQueue<Integer>order = new PriorityQueue<>();
            while(!priorityQueue.isEmpty()) {
                Entry e = priorityQueue.poll();
                sum += e.value;
                order.add(e.position);
            }
            System.out.println(sum);
            while(!order.isEmpty()) {
                System.out.print(order.poll() + " ");
            }
        } else {
            System.out.println(-1);
        }
        input.close();
    }
}
