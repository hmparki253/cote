package implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class AlphaNumberOrdering {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else {
                sum += c - '0';
            }
        }

        char[] cArr = sb.toString().toCharArray();
        Arrays.sort(cArr);

        bw.write(cArr);
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
