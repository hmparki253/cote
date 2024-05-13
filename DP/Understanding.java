package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Understanding {
    
    /**
     * 기존의 재귀를 다시 구현해보기
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        System.out.println(fibo(x));
    }

    private static int fibo(int x) {
        if(x == 1 || x == 2) return 1;
        return fibo(x - 1) + fibo(x - 2);
    }
}
