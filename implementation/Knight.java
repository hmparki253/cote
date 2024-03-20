package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Knight {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String input = st.nextToken();

        int row = input.charAt(0) - '0';
        int column = input.charAt(1) - 'a' + 1;

        int result = 0;
        int nextRow = 0;
        int nextColumn = 0;

        int[] dx = {-2, -1,  1,  2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2,  2,  1};


        for(int i = 0; i < dx.length; i++) {
            nextRow = row + dx[i];
            nextColumn = column + dy[i];

            if(nextRow < 1
                || nextRow > 8
                || nextColumn < 1
                || nextColumn > 8) continue;

            result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
