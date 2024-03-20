package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Keunsu {
    // 예제 3-2
    /**
     * 다양한 수로 이루어진 배열이 있을 때,
     * 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙
     * 단 특정한 인덱스에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없다
     * 
     * ex) 2,4,5,4,6으로 이루어진 배열
     *     M은 8
     *     K는 3
     *     6, 6, 6, 5, 6, 6, 6, 5
     * 
     * @param args
     */
    public static void main(String[] args) throws IOException {
        // TODO: 입력받기
        // 5 8 3
        // 2 4 5 4 6 -> 46
        // 코테에서는 데이터를 띄어쓰기 기준으로 1 2 3 4 5과 같은 형태로 데이터를 입력받아야 하는 경우가 있다. 
        // 따라서 개행단위로 입력을 받는 readLine()으로는 이를 구현할 수 없으므로 
        // 부가적으로 StringTokenizer나 split()을 통해 "1", "2" ..."5"로 따로 입력을 받고 배열에 집어 넣어야 한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);
        int first = arr[n - 1];
        int second = arr[n - 2];

        // 가장 큰 수가 더해지는 횟수 계산
        // 수열은 k + 1 로 이루어지고
        // 수열이 반복된다 최대 값 k와 그 다음 최대 값 하나의 조합
        // 으로 나누면 
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k+1);
       
        int result = 0;
        result += cnt * first;
        result += (m - cnt) * second;

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
