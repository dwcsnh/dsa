package Tuan13;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    static class Edge implements Comparable<Edge> {
        int to;
        int from;
        int weight;

        public Edge(int to, int from, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            int difference = this.weight - other.weight;
            if (difference != 0) {
                return difference;
            }
            return this.to + this.from - other.to - other.from;
        }
    }

    static int parent(int node, int[] nodes) {
        while (nodes[node] != -1) {
            node = nodes[node];
        }
        return node;
    }

    static void union(int x, int y, int[] nodes) {
        nodes[y] = x;
    }

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the
     * edge is <name>Weight[i].
     *
     */

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        Edge[] edges = new Edge[gFrom.size()];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new Edge(gTo.get(i), gFrom.get(i), gWeight.get(i));
        }
        Arrays.sort(edges);

        int minimumWeight = 0;
        int[] nodes = new int[gNodes + 1];
        Arrays.fill(nodes, -1);

        for (Edge edge : edges) {
            int x = parent(edge.from, nodes);
            int y = parent(edge.to, nodes);
            if (x != y) {
                minimumWeight += edge.weight;
                union(x, y, nodes);
            }
        }

        return minimumWeight;
    }

}

public class KruskalMST {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] gFromToWeight = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                gFrom.add(Integer.parseInt(gFromToWeight[0]));
                gTo.add(Integer.parseInt(gFromToWeight[1]));
                gWeight.add(Integer.parseInt(gFromToWeight[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(String.valueOf(res));
        bufferedReader.close();
        bufferedWriter.close();
    }
}
