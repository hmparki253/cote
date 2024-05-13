package DP;

public class Fibo {
    public static void main(String[] args) {
        System.out.println("result is : " + fibo(7));
    }

    private static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            // dp[2] = dp[1] (1) + dp[0] (0) : 1
            // dp[3] = dp[2] (1) + dp[1] (1) : 2
            // dp[4] = dp[3] (2) + dp[2] (1) : 3
            // dp[5] = dp[4] (3) + dp[3] (2) : 5
            // dp[6] = dp[5] (5) + dp[4] (3) : 8
            // dp[7] = dp[6] (8) + dp[5] (5) : 13
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
