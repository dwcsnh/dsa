package Tuan13;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimMST {
    static class Vertex {
        List<Edge> adj;

        public Vertex() {
            adj = new ArrayList<>();
        }
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int weight;

        public Edge(int start, int weight) {
            this.start = start;
            this.weight = weight;
        }

        public int compareTo(Edge that) {
            if (this.weight < that.weight) {
                return -1;
            } else if (this.weight == that.weight) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    static int prim(Vertex[] graph, int start) {
        boolean[] visited = new boolean[graph.length + 1];
        visited[start] = true;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(graph[start].adj);
        int minimumWeight = 0;

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!visited[edge.start]) {
                visited[edge.start] = true;
                minimumWeight += edge.weight;
                priorityQueue.addAll(graph[edge.start].adj);
            }
        }
        return minimumWeight;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        Vertex[] graph = new Vertex[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new Vertex();
        }
        int u, v, w;
        for (int i = 0; i < m; i++) {
            u = input.nextInt();
            v = input.nextInt();
            w = input.nextInt();
            Edge e1 = new Edge(u, w);
            Edge e2 = new Edge(v, w);
            graph[u].adj.add(e2);
            graph[v].adj.add(e1);
        }
        w = input.nextInt();
        System.out.println(prim(graph, w));
        input.close();
    }
}
