package recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DFS {

    public static int[][] dfsGraph = {
        {}, // 0번지는 비워야지
        {2,3,8}, // 1
        {1,7},   // 2
        {1,4,5}, // 3
        {3,5},   // 4
        {3,4},   // 5
        {7},     // 6
        {2,6,8}, // 7
        {1,7}    // 8
    };

    public static boolean[] visited = new boolean[dfsGraph.length];
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dfs(dfsGraph, 1, visited, bw);
        
        bw.flush();
        bw.close();
    }

    public static void dfs(int[][] graph, int v, boolean[] visited, BufferedWriter bw) throws IOException {
        visited[v] = true;
        bw.write(String.valueOf(v) + " ");
        
        for(int i = 0; i < graph[v].length; i++) {
            int j = graph[v][i];
            if(!visited[j])
                dfs(graph, j, visited, bw);
        }
    }
}
