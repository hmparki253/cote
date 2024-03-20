package recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Factorial {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(factorial(n)));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int factorial(int n) {
        if(n <= 1)
            return 1;
        else 
            return n * factorial(n - 1);
    }
}
