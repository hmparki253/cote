package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SanghaZwaWoo {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        String[] traveling = new String[st.countTokens()];
        int i = 0;
        while(st.hasMoreTokens()) {
            traveling[i] = st.nextToken();
            i++;
        }

        int x = 1;
        int y = 1;

        int[] xArr = { 0, 0, -1, 1};
        int[] yArr = {-1, 1,  0, 0};
        String[] waysArr = {"L", "R", "U", "D"};

        for(int j = 0; j < traveling.length; j++) {
            int nx = -1, ny = -1;
            for(int k = 0; k < waysArr.length; k++) {
                if(traveling[j].equals(waysArr[k])) {
                    nx = x + xArr[k];
                    ny = y + yArr[k];
                }
            }
            if(nx < 1 || ny < 1 || nx > n || ny > n) continue;
            x = nx;
            y = ny;
        }

        bw.write(String.valueOf(x));
        bw.write(" ");
        bw.write(String.valueOf(y));
    
        br.close();
        bw.flush();
        bw.close();
    }
}
