package Tuan12;

import java.util.*;

public class RoadsAndLibraries {
    static List<List<Integer>> adj;
    static boolean[] visited;
    static int count;

    static long minimumCost(int libraryCost, int roadCost) {
        long cost = 0;
        
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                count = 0;
                dfs(i);
                if (libraryCost > roadCost) {
                    cost += libraryCost + roadCost * (count - 1); 
                } else {
                    cost += libraryCost * count;
                }
            }
        }
        
        return cost;
    }
    
    static void dfs(int i) {
        visited[i] = true;
        count++;
        
        List<Integer> list = adj.get(i);
  
        for (int j = 0; j < list.size(); j++) {
            if (!visited[list.get(j)]) {
                dfs(list.get(j));
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        for(int i = 0; i < q; i++){
            int n = input.nextInt();
            visited = new boolean[n];
            adj = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                adj.add(new ArrayList<>());
            }
            
            int m = input.nextInt();
            int libraryCost = input.nextInt();
            int roadCost = input.nextInt();
            
            for(int k = 0; k < m; k++){
                int city1 = input.nextInt();
                int city2 = input.nextInt();
                adj.get(city1 - 1).add(city2 - 1);
                adj.get(city2 - 1).add(city1 - 1);
            }
            
            System.out.println(minimumCost(libraryCost, roadCost));
        }
        input.close();
    }
}
