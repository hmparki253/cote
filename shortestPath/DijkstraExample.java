package shortestPath;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 기본 방법으로 풀어보기
 */
public class DijkstraExample {

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int V = 5; // 정점의 수
    public static boolean[] visited;
    public static int[] dist;
    
    public static void main(String[] args) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<Node>());
        }

        addNode(1, 2, 10);
        addNode(1, 4, 30);
        addNode(1, 5, 100);
        addNode(2, 3, 50);
        addNode(3, 5, 10);
        addNode(3, 4, 20);
        addNode(4, 5, 60);

        dist = new int[V + 1];          // 
        visited = new boolean[V + 1];   // 해당 노드 방문 여부 저장

        int start = 1;

        dijkstra(start, V);

        System.out.println();
        System.out.println();
        System.out.println("Shortest Path Weight By Dijkstra O(V^2): " + dist[V]);
    }

    private static void dijkstra(int start, int V) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        dist[start] = 0;

        for(int i = 0; i < V; i++) {
            
            int u = selectMinNode(V); // 해당 노드 선택하기
            visited[u] = true;

            for (Node node : graph.get(u)) {
                int v = node.getTarget();
                int weight = node.getWeight();

                if (!visited[v] && dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
    }

    private static void addNode(int u, int v, int w) {
        graph.get(u).add(new Node(v, w));
        graph.get(v).add(new Node(u, w)); // 무방향 그래프인 경우
    }

    private static int selectMinNode(int V) {
        int min = Integer.MAX_VALUE;
        int node = -1;

        for(int i = 1; i <= V; i++) {
            if(!visited[i] && dist[i] < min) {
                min = dist[i];
                node = i;
            }
        }   

        return node;
    }
}

class Node {
    private int target;
    private int weight;

    public Node(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    int getTarget() {
        return this.target;
    }

    int getWeight() {
        return this.weight;
    }
}

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        // 비용을 비교 할 것인데 가장 적은 비용인 녀석이여야함
        return o1.getWeight() - o2.getWeight();
    }

}

class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.aScore - o2.aScore;
    }

}

class Student {
    int aScore;
    int bScore;

    public Student(int aScore, int bScore) {
        this.aScore = aScore;
        this.bScore = bScore;
    }
}

