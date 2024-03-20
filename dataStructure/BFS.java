package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    
    public static void main(String[] args) {
        int[][] graph = {
            {},
            {2,3,8}, // 1번 노드가 2,3,8 노드와 연결됨
            {1,6,8}, // 2번 노드가 1,6,8 노드와 연결됨
            {1,5}, // 3번 노드가 1,5 노드와 연결됨
            {5,7}, // 4번 노드가 5,7 노드와 연결됨
            {3,4,7}, // 5번 노드가 3,4,7 노드와 연결됨
            {2}, // 6번 노드가 2번 노드와 연결됨
            {4,5}, // 7번 노드가 4,5 노드와 연결됨
            {1,2} // 8번 노드가 1,2 노드와 연결됨
        };


        boolean[] visited = new boolean[9];

        System.out.println(bfs(1, graph, visited));
    }

    static String bfs(int start, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        visited[start] = true;  // 시작 노드 방문처리

        while(!q.isEmpty()) {
            int nodeIndex = q.poll();   // 큐의 최상위 헤드를 뽑아 변수에 할당하고, 큐에서는 제거해준다.
            sb.append(nodeIndex + " -> ");

            for(int i = 0; i<graph[nodeIndex].length; i++) {
                int temp = graph[nodeIndex][i];
                if(!visited[temp]) {
                    visited[temp] = true;
                    q.offer(temp);
                }
            }
        }

        return sb.toString();
    }
}
