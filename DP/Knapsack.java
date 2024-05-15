package DP;

public class Knapsack {
    // 핵심은 배낭에 포함시킬것인가? or 포함시키지 않을 것인가?

    public static void main(String[] args) {
        int[] value = {60, 100, 120};   // 각 물건의 가치
        int[] weight = {10, 20, 30};    // 각 물건의 무게
        int mW = 50;    // 냅색의 최대 수용 무게
        int n = value.length; // 아이템의 수
        System.out.println();
        System.out.println("value:" + knapsack(mW, weight, value, n));
        System.out.println();
    }

    /**
     * 
     * @param mW: knapsack의 maxWeight 
     * @param weight: 무게들 {10, 20, 30}
     * @param value : 각 값 {60, 100, 120}
     * @param n : 총 물건 종류 갯수 3
     * @return
     */
    private static int knapsack(int mW, int[] weight, int[] value, int n) {
        int[][] dp = new int[n + 1][mW + 1]; // int[4: 0~3][51: 0~50]
        // [0][w], [i][0]은 0이므로 제외하고 계산
        for(int i = 1; i < n + 1; i++) { // 3
            for(int w = 1; w < mW + 1; w++) { // 50
                 if(weight[i - 1] <= w) {
                    dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][mW]; // 최대 가치 반환
    }
}
