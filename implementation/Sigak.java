package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Sigak {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        
        for(int time = 0; time <= n; time++) {
            for(int minute = 0; minute < 60; minute++) {
                for(int second = 0; second < 60; second++) {
                    if(String.valueOf(time).contains("3")
                        || String.valueOf(minute).contains("3")
                        || String.valueOf(second).contains("3")
                    ) count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
