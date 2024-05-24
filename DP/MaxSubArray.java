package DP;

public class MaxSubArray {
    
    /**
     * 배열 중 최대 합을 가지는 연속된 배열의 합 구하기
     * Math.max를 이용할 확률이 높아보임
     * 더하다가 이전것보다 크면 새로 시작하는게 컨셉
     * 이걸 일종의 슬라이딩 윈도우라고 봐도 됨
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 4, 5, 1, 2, 7, -6};

        System.out.println("결과 값 : " + maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        // 글로벌 max값 (지금까지 더해서 가장 큰 값 두고)
        int curMax = nums[0];
        int gblMax = nums[0];

        for(int i = 2; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            if(curMax > gblMax) {
                gblMax = curMax;
            }
        }

        return gblMax;
    }
}
