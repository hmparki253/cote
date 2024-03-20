package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SutjaCard {
    /**
     * 목적: 카드들 중 가장 큰 숫자를 뽑는 것
     * 룰: 1. 행을 선택하고 그 행에서 가장 작은 카드를 뽑는다
     * 2. 그 중에서 가장 큰 숫자 카드를 뽑는다.
     * 
     * 입력 예시
     * 3 3
     * 3 1 2
     * 4 1 4
     * 2 2 2 
     * 
     * 출력 예시 2
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 줄 읽어서
        // 행(n) * 열(m)
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxOfMin = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            int minInRow = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++) {
                if(arr[i][j] < minInRow) {
                    minInRow = arr[i][j];
                }
            }
            if(minInRow > maxOfMin) {
                maxOfMin = minInRow;
            }
        }
        bw.write(String.valueOf(maxOfMin));
        bw.flush();
        bw.close();
    }
}
