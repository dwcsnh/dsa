package bonus;

import java.util.Scanner;

public class Query {
    public static int n;
    public static int[] segmentTree;
    public static int[] a;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        a = new int[n + 5];
        segmentTree = new int[4 * n + 5];
        for (int i = 1; i <= n; i++) {
            a[i] = input.nextInt();
        }
        int q = input.nextInt();
        build(1, 1, n);
        for (int i = 0; i < q; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            System.out.println(get(1, 1, n, u, v));
        }
        input.close();
    }

    public static void build(int id, int l, int r) {
        if (l == r) {
            segmentTree[id] = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(id*2, l, mid);
        build(id*2 + 1, mid+1, r);
        segmentTree[id] = Math.max(segmentTree[id*2], segmentTree[id*2 + 1]);
    }

    private static int get(int id, int l, int r, int u, int v) {
        if (v < l || r < u) {
            return -9999999;
        }
        if (u <= l && r <= v) {
            return segmentTree[id];
        }
        int mid = (l + r) / 2;
        return Math.max(get(id*2, l, mid, u, v), get(id*2 + 1, mid+1, r, u, v));
    } 
}

