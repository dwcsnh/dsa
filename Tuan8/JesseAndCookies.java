package Tuan8;

import java.util.Scanner;

public class JesseAndCookies {
    private int[] pq = new int[1000000 + 5];
    private int size = 0;

    public int getTop() {
        return pq[1];
    }

    public void swim(int k) {
        while (k > 1 && pq[k] < pq[k / 2]) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    public void sink(int k) {
        while (k * 2 <= size) {
            int j = k * 2;
            if(j < size && pq[j] > pq[j + 1]) {
                j++;
            }
            if (pq[k] < pq[j]) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    public void add(int value) {
        pq[++size] = value;
        swim(size);
    }

    public void removeTop() {
        swap(1, size);
        pq[size] = 0;
        size--;
        sink(1);
    }

    public int getSize() {
        return size;
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(pq[i] + " ");
        }
        System.out.println();
    }

    public void swap(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public boolean check(int k) {
        return pq[1] > k;
    }
    
    public boolean isEmpty() {
        return size <= 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        JesseAndCookies minPQ = new JesseAndCookies();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            minPQ.add(x);
        }
        int steps = 0;
        while (!minPQ.check(k) && minPQ.getSize() > 1) {
            steps++;
            int min1 = minPQ.getTop();
            minPQ.removeTop();
            int min2 = minPQ.getTop();
            minPQ.removeTop();
            minPQ.add(min1 + 2 * min2);
        }
        if (minPQ.getTop() < k) {
            steps = -1;
        }
        System.out.println(steps);
        input.close();
    }
}

