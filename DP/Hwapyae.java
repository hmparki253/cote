package DP;

import java.util.Arrays;

public class Hwapyae {
    
    public static void main(String[] args) {
        // n가지 종류의 화폐가 있는데 (k = 각 화폐의 단위 )
        // 이걸 조합해서 m을 만드는 최소 경우의 수( A(i) )를 구하기
        // 불가능하면 -1로 출력

        // 1 <= N <= 1000, 1<= M <=10000

        int m = 15;
        int[] arr = {2, 3};

        System.out.println(solve(arr, arr.length, m));
        // 무한대의 수 세팅해주기
    }

    public static int solve(int[] arr, int n, int m) {
        int[] dp = new int[m + 1];
        Arrays.fill(dp, 10001);

        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = arr[i]; j <= m; j++) {
                if(dp[j - arr[i]] != 10001) {
                    dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
                }
            }
        }
        if(dp[m] == 10001) return -1;
        else return dp[m]; 
    }
}
