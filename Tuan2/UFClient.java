package Tuan2;

public class UFClient {
    private int[] uf = new int[100000 + 5];
    private int N;
    private int components;

    public UFClient(int N) {
        this.N = N;
        this.components = N;
        for (int i = 0; i < N; i++) {
            uf[i] = -1;
        }
    }

    public boolean isConnected() {
        return components == 1;
    }

    public int getRoot(int p) {
        if (uf[p] < 0) {
            return p;
        }
        return uf[p] = getRoot(uf[p]);
    }

    public boolean connected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public int getSize(int p) {
        if (uf[p] < 0) {
            return uf[p];
        }
        return getSize(uf[p]);
    }

    public void union(int p, int q) {
        int sizeP = getSize(p);
        int sizeQ = getSize(q);

        if (sizeP < sizeQ) {
            uf[getRoot(p)] = getRoot(q);
            uf[getRoot(q)] = sizeP + sizeQ;
        }
        if (sizeP > sizeQ) {
            uf[getRoot(q)] = getRoot(p);
            uf[getRoot(p)] = sizeP + sizeQ;
        }
        if (sizeP == sizeQ) {
            uf[getRoot(p)] = getRoot(q);
            uf[getRoot(q)] = sizeP + sizeQ;
        }
        components--;
    }

    public void printUnion() {
        for (int i = 0; i < N; i++) {
            System.out.print("   " + i);
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            if (uf[i] >= 0) {
                System.out.print("   " + uf[i]);
            } else {
                System.out.print("  " + uf[i]);
            }
        }
    }

    public int numberOfComponents() {
        return components;
    }
}
