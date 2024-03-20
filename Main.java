import java.util.*;

public class Main {
    public ArrayList<Integer> solution01(int[] input) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(input[0]);
        for(int i = 1; i < input.length; i++) {
            if(input[i] > input[i-1]) result.add(input[i]);
        }
        return result;
    }

    public int solution02(int[] input) {
        int result = 0;
        int max = 0;
        for(int i = 0; i < input.length; i++) {
            if(max < input[i]) {
                max = input[i];
                result++;
            } 
        }
        return result;
    }

    public ArrayList<String> solution03(int[][] input) {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < input[0].length; i++) {
            int a = input[0][i];
            int b = input[1][i];
            if(a == b) result.add("D");
            else if(a == 1 && b == 3) result.add("A");
            else if(a == 2 && b == 1) result.add("A");
            else if(a == 3 && b == 2) result.add("A");
            else result.add("B");
        }
        return result;
    }

    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);
        int arrCnt = sc.nextInt();
        int[][] input = new int[2][arrCnt];
        for(int i = 0; i < arrCnt; i++) {
            input[0][i] = sc.nextInt();
        }

        for(int i = 0; i < arrCnt; i++) {
            input[1][i] = sc.nextInt();
        }

        for(String x : t.solution03(input)) {
            System.out.println(x);
        }
    }
}