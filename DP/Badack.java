package DP;

public class Badack {
    
    // 바닥: 가로의 길이가 N | 세로의 길이가 2인 직사각형
    // 덮개는 1 * 2 | 2 * 1 | 2 * 2 총 세 가지가 있음

    // 바닥을 덮을 수 있는 모든 경우의 수

    // 점화식 Ai = A(i-1) + A(i-2) + A(i-2)
    // A(i) = A(i-1) + 2 * A(i-2)
    // % DIVIDER
    public static void main(String[] args) {
        
        System.out.println(calc(3));
    }

    public static int calc(int n) {
        int DIVIDER = 796796;
        int[] dp = new int[n + 1];

        dp[1] = 1;  // 2*1 짜리 1개 넣는 경우 하나
        dp[2] = 3;  // 2*1 짜리 2개 넣는 경우 하나, 1*2짜리 두 개 넣는 경우 하나, 2*2짜리 하나 넣는 경우 하나

        for(int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % DIVIDER;
        }

        return dp[n];
    }
}
