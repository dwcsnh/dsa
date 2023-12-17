package Tuan12;

import java.util.Scanner;

public class ConnectedCells {
    public static int[][] matrix = new int[10000][10000];
    public static boolean[][] visited = new boolean[10000][10000];
    public static int n;
    public static int m;
    public static int max = 0;
    public static int[] stepY = {1, -1, 0, 0, 1, 1, -1, -1};
    public static int[] stepX = {0, 0, -1, 1, -1, 1, -1, 1};

    public static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public static int findLargestRegion() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1 && visited[i][j] == false) {
                    visited[i][j] = true;
                    int size = explore(i, j);
                    if (size > max) {
                        max = size;
                    }
                }
            }
        }
        return max;
    }

    public static int explore(int x, int y) {
        int size = 1;
        for (int i = 0; i < 8; i++) {
            int xPos = x + stepX[i];
            int yPos = y + stepY[i];
            if (isValid(xPos, yPos)) {
                if (matrix[xPos][yPos] == 1 && visited[xPos][yPos] == false) {
                    visited[xPos][yPos] = true;
                    size += explore(xPos, yPos);
                }
            }
        }
        return size;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = input.nextInt();
                visited[i][j] = false;
            }
        }
        input.close();
        System.out.println(findLargestRegion());
    }
}

