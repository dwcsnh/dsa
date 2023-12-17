package Tuan12;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER m
     * 3. 2D_INTEGER_ARRAY edges
     * 4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // Write your code here
        List<Integer> distances = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        int weight[][] = new int[n + 1][n + 1];
        boolean visited[] = new boolean[n + 1];
        visited[0] = true;
        visited[s] = true;
        
        for (int i = 0; i < m; i++) {
            int x = edges.get(i).get(0);
            int y = edges.get(i).get(1);
            weight[x][y] = 6;
            weight[y][x] = 6;
        }

        for (int i = 0; i <= n; i++) {
            distances.add(-1);
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int i = 0; i < n + 1; i++) {
                if (!visited[i] && weight[v][i] != 0) {
                    queue.add(i);
                    visited[i] = true;
                    if (distances.get(v) == -1) {
                        distances.set(i, weight[v][i]);
                    } else
                        distances.set(i, distances.get(v) + weight[v][i]);
                }
            }
        }
        distances.remove(s);
        distances.remove(0);

        return distances;
    }

}

public class BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
