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
     * @param weight: 무게들
     * @param value : 각 값
     * @param n : 총 물건 종류 갯수
     * @return
     */
    private static int knapsack(int mW, int[] weight, int[] value, int n) {
        int i, w;
        int[][] K = new int[n + 1][mW + 1]; // 3 + 1 , 50 + 1 [4][51] -> 0~3 -> 0 ~ 51
        for(i = 0; i <= n; i++) { // 0 | 3 | 1
            for(w = 0; w <= mW; w++) { // 0 | 50 | 1
                // 1 | 50 | 2
                if(i == 0 || w == 0) {
                    K[i][w] = 0; 
                    // k[0][0] = 0
                    // k[0][1] = 0
                    // k[0][2] = 0
                    // ...
                    // k[0][49] = 0
                    // k[1][0] = 0
                }
                else if(weight[i - 1] <= w) {
                    // weight[0] (10) <= 
                    K[i][w] = Math.max(value[i - 1] + K[i - 1][w - weight[i - 1]], K[i - 1][w]);
                }
                else {
                    // K[1][1] = K[0][1];
                    K[i][w] = K[i - 1][w];
                }
            }
        }
        return K[n][mW]; // 최대 가치 반환
    }
}
