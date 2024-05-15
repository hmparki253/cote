package DP;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class MakeOne {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        System.out.println(String.valueOf(calculate(x)));
    }

    // * 1이 될때 까지의 연산의 총 횟수를 구하기
    // 연산 4가지를 적절히 조합함
    // 1. x가 5로 나누어 떨어지는 경우 5로 나눔
    // 2. x가 3으로 나누어 떨어지는 경우 3으로 나눔
    // 3. x가 2로 나누어 떨어지는 경우 2로 나눔
    // 4. x에서 1을 뺌
    public static int calculate(int x) {
        int[] dp = new int[30001];

        for(int i = 2; i < x + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            } 
        }

        
        return dp[x];
    }


}
