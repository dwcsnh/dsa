package Tuan13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DijkstraShortestReach {
    static class Edge implements Comparable<Edge> {
        int start;
        int weight;

        public Edge(int v, int weight) {
            this.start = v;
            this.weight = weight;
        }

        public int compareTo(Edge that) {
            return Integer.compare(this.weight, that.weight);
        }
    }

    static class Graph {
        List<Edge>[] adj;

        public Graph(int n) {
            adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        void addEdge(int u, int v, int w) {
            adj[u].add(new Edge(v, w));
            adj[v].add(new Edge(u, w));
        }
    }

    static int[] dijkstra(int start, Graph graph, int n) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int node = current.start;
            int distance = current.weight;

            if (distance > distances[node]) {
                continue;
            }

            for (Edge neighbor : graph.adj[node]) {
                int newDistance = distance + neighbor.weight;
                if (newDistance < distances[neighbor.start]) {
                    distances[neighbor.start] = newDistance;
                    pq.offer(new Edge(neighbor.start, newDistance));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            String[] inputNM = br.readLine().split(" ");
            int n = Integer.parseInt(inputNM[0]);
            int m = Integer.parseInt(inputNM[1]);

            Graph graph = new Graph(n);

            for (int i = 0; i < m; i++) {
                String[] edgeInfo = br.readLine().split(" ");
                int u = Integer.parseInt(edgeInfo[0]);
                int v = Integer.parseInt(edgeInfo[1]);
                int w = Integer.parseInt(edgeInfo[2]);
                graph.addEdge(u, v, w);
            }

            int start = Integer.parseInt(br.readLine());
            int[] shortestDistances = dijkstra(start, graph, n);

            StringBuilder result = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (i != start) {
                    result.append(shortestDistances[i] == Integer.MAX_VALUE ? -1 : shortestDistances[i]).append(" ");
                }
            }
            System.out.println(result);
        }
    }
}
