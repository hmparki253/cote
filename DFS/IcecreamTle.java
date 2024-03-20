package DFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IcecreamTle {
    public static int tle[][];
    public static int n = 0;
    public static int m = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int icecreamCnt = 0;

        tle = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            String tleRow = br.readLine();
            for(int j = 0; j < m; j++) {
                tle[i][j] = tleRow.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dfs(i, j)) icecreamCnt++; 
            }
        }

        bw.write(String.valueOf(icecreamCnt));
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean dfs(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m)
            return false;
        if(tle[x][y] == 0) {
            tle[x][y] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }
}
