package dataStructure;

import java.util.Stack;

public class DFS {
    
    public static void main(String[] args) {
        int[][] dfsGraph = {
            {}, // 0번지는 비워야지
            {2,3,8},
            {1,7}, 
            {1,4,5}, 
            {3,5},
            {3,4},
            {7}, 
            {2,6,8}, 
            {1,7}
        };


        boolean[] visited = new boolean[9];

        dfs(dfsGraph, visited);
    }

    static void dfs(int[][] graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        
        while(!stack.isEmpty()) {    
            int nodeIndex = stack.pop();        
            if (visited[nodeIndex]) continue;
            visited[nodeIndex] = true;    

            System.out.print(nodeIndex + " -> ");        
            
            // 꺼낸 노드와 인접한 노드 찾기    
            for (int LinkedNode : graph[nodeIndex]) {        
                if(!visited[LinkedNode]) {            
                    stack.push(LinkedNode);        
                }
            }    
        }
    }
}
