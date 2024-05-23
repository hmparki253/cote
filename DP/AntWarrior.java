package DP;

public class AntWarrior {
    
    // 1 ~ 2칸씩 선택하기
    // i - 1까지를 선택할 것인지 i - 2까지를 선택할 것인지를 선택하는 형태가 된다
    // max(foods[i-1], foods[i-2] + k)
    public static void main(String[] args) {
        int[] inventory = { 1, 3, 1, 5 };
        System.out.println(String.valueOf(calc(inventory)));
    }

    public static int calc(int[] inventory) {
        int[] dp = new int[inventory.length];

        dp[0] = inventory[0];
        dp[1] = Math.max(inventory[0], inventory[1]);

        for(int i = 2; i < inventory.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + inventory[i]);
        }

        return dp[inventory.length - 1];
    }
}
