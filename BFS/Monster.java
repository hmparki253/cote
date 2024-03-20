package BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Monster {
    // 5 - 11
    public static int n = 0;
    public static int m = 0;
    public static int[][] graph;

    public static int[] dx = {-1, 1, 0, 0 };
    public static int[] dy = {0, 0, -1 ,1 };

    public static void main(String[] args) throws IOException {
        // 이 문제는 손코딩 해본 결과 모든 갈 수 있는 곳들을 마스킹을 하는 형태가 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for(int i = 0; i < n; i++) {
            String row = br.readLine();
            for(int j = 0; j < m; j++) {
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        bw.write(String.valueOf(bfs(0,0)));
        bw.flush();
        bw.close();
    }

    // 모든 곳을 다 순회해야함
    public static int bfs(int xI, int yI) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(xI, yI));

        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 확인
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(graph[nx][ny] == 0) continue;
                if(graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                } 
            }
        }

        return graph[n-1][m-1];
    }
}

class Node {
    public int x;
    public int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}