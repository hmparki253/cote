package greedy;

public class Geosleum {
    // 예제 3-1
    /**
     * 당신은 음식점의 계산을 도와주는 점원,
     * 거스름돈으로 [500, 100, 50, 10] 원 짜리 동전이 무한히 존재
     * 거슬러 줘야하는 돈이 N일때, 동전의 최소 개수를 구하기 (N은 10의 배수이다)
     * @param args
     */
    public static void main(String[] args) {
        // 그리디이기때문에 항상 큰 단위를 우선해서 거슬러주자
        int n = 1260;
        int count = 0;
        
        int[] coinTypesArr = {500, 100, 50, 10};

        for(int coin : coinTypesArr) {
            count += n / coin;  // 최대한 나누고
            n %= coin;  // 남은 나머지를 
        }

        System.out.println(count);
    }
}
