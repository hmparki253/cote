package DP;

import java.util.Arrays;

/**
 * 최장 공통 수열
 * @return
 */
public class LCS {
    
    public static void main(String[] args) {
        lcs2("banaan", "vbankn");
        // System.out.println(lcs2("banaan", "vbankn"));
    }

    public static String lcs(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = n - 1; i >= 0; i--) {
            // i:6
            for(int j = m - 1; j >= 0; j--) {
                // j:6
                if(a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;    // 같으면 1증가 시켜주기?
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);    // 
                }
            }
        }

        for(int i = 0; i < dp.length; i++) {
            System.out.println("생성된 2차원 배열 :: " + Arrays.toString(dp[i]));
        }

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < n && j < m) {
            if(a.charAt(i) == b.charAt(j)) {
                sb.append(a.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] >= dp[i][j + 1]) i++;
            else j++;
        }

        return sb.toString();
    }

    public static void lcs2(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for(int i = 0; i < dp.length; i++) {
            System.out.println("생성된 2차원 배열 :: " + Arrays.toString(dp[i]));
        }

        int i = n, j = m;
        StringBuilder lcsStr = new StringBuilder();

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                lcsStr.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("LCS: " + lcsStr.reverse().toString());
    }
}
