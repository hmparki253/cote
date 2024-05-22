package DP;

public class Stairs {
    
    /**
     * 계단 문제
     * 한 번에 한 칸 혹은 두 칸만 이동 가능
     * @param args
     */
    public static void main(String[] args) {
        int cost[] = {5, 15, 20};

        System.out.println();
        System.out.println(move(cost));
        System.out.println();
    }

    public static int move(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
