package bonus;

import java.util.Scanner;

public class Queries2 {
    public static int n;
    public static int[] segmentTree;
    public static int[] a;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q, type, u, v;
        n = input.nextInt();
        a = new int[n + 5];
        segmentTree = new int[4 * n + 5];
        for (int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
        }
        build(1, 1, n);
        q = input.nextInt();
        for (int i = 0; i < q; i++) {
            type = input.nextInt();
            if (type == 1) {
                u = input.nextInt();
                v = input.nextInt();
                System.out.println(getMin(1, 1, n, u, v));
            } else {
                u = input.nextInt();
                v = input.nextInt();
                update(1, 1, n, u, v);
            }
        }
        input.close();
    }

    public static void build(int id, int l, int r) {
        if (l == r) {
            segmentTree[id] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(id * 2, l, mid);
        build(id * 2 + 1, mid + 1, r);
        segmentTree[id] = Math.min(segmentTree[id * 2], segmentTree[id * 2 + 1]);
    }

    public static int getMin(int id, int l, int r, int u, int v) {
        if (u > r || v < l) {
            return Integer.MAX_VALUE;
        }
        if (u <= l && r <= v) {
            return segmentTree[id];
        }
        int mid = (l + r) / 2;
        return Math.min(getMin(id * 2, l, mid, u, v), getMin(id * 2 + 1, mid + 1, r, u, v));
    }

    public static void update(int id, int l, int r,int i, int v) {
        if (i < l || i > r) {
            return;
        }
        if (l == r) {
            segmentTree[id] = v;
            return;
        }
        int mid = (l + r) / 2;
        update(id * 2, l, mid, i, v);
        update(id * 2 + 1, mid + 1, r, i, v);
        segmentTree[id] = Math.min(segmentTree[id * 2], segmentTree[id * 2 + 1]);
    }
}

