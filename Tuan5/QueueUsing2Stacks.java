package Tuan5;

import java.util.Scanner;

public class QueueUsing2Stacks {
    static class Stack {
        int[] stack = new int[100000 + 5];
        int top = -1;

        public void add(int x) {
            stack[++top] = x;
        }

        public boolean isEmpty() {
            return top < 0;
        }

        public int poll() {
            if (!isEmpty()) {
                return stack[top--];
            }
            return -999999;
        }

        public int getTop() {
            return stack[top];
        }

        public int size() {
            return top + 1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack enqueue = new Stack();
        Stack dequeue = new Stack();
        int n, q, x;
        n = input.nextInt();
        for (int i = 0; i < n; i++) {
            q = input.nextInt();
            if (q == 1) {
                x = input.nextInt();
                enqueue.add(x);
            } else if (q == 2) {
                if (dequeue.isEmpty()) {
                    while(!enqueue.isEmpty()) {
                        dequeue.add(enqueue.poll());
                    }
                }
                dequeue.poll();
            } else if (q == 3) {
                if (dequeue.isEmpty()) {
                    while(!enqueue.isEmpty()) {
                        dequeue.add(enqueue.poll());
                    }
                }
                System.out.println(dequeue.getTop());
            }
        }
        input.close();
    }
}
