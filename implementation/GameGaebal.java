package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class GameGaebal {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] visited = new int[n][m];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        // 시작점 방문 처리
        visited[x][y] = 1;
        int count = 1;
        int turnTime = 0; // 방향전환이 4면 모두 막혔으면
        
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            direction = turnLeft(direction);
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 미방문이고, 육지면
            if(visited[nx][ny] == 0 && map[nx][ny] == 0) {
                // 방문 카운트 증가시키자
                visited[nx][ny] = 1; // 방문처리
                x = nx;
                y = ny;
                count++; // 카운트 증가
                turnTime = 0; // 회전 횟수 초기화
                continue;
            } else {
                turnTime++;
            }

            if(turnTime == 4) { // 뒤로 이동하고, 현재 좌표 세팅, 하고 다시 반시계 방향으로 돌자
                nx = x - dx[direction];
                ny = y - dy[direction];

                if(map[nx][ny] == 0) { 
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
                turnTime = 0;
            }
        }

        bw.write(String.valueOf(count));

        br.close();
        bw.flush();
        bw.close();
    }

    public static int turnLeft(int direction) {
        // 북:0, 동:1, 남:2, 서:3
        direction = direction - 1;
        if(direction == -1) direction = 3;
        return direction;
    }
}
