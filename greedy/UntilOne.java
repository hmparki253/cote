package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class UntilOne {
    
    /**
     * 1이 될때까지
     * 1. k - 1
     * 2. k / m
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = 0;

        while(true) {
            int target = (n / k) * k;
            result = result + (n - target);
            n = target;
            if(n < k) break;
            result += 1;
            n = n / k;
        }

        result = result + n - 1;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
