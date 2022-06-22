package com.phm.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] hell = {
                10056,
                14450,
                2898,
                32694,
                38947,
                4619,
                46387,
                46414,
                5706,
                63638,
                66011,
                75224,
                7670,
                78862,
                92905,
                93109,
                96964
        };

        Arrays.sort(hell);
        System.out.println(Arrays.toString(hell));
//	    int a = 1;
//	    while(true) {
//	        // V일간 P일 중 L일만 연속 가능함
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int L = Integer.parseInt(st.nextToken());
//            int P = Integer.parseInt(st.nextToken());
//            int V = Integer.parseInt(st.nextToken());
//
//            if(L == 0 || P == 0 || V == 0) break;
//
//            int option = Math.min((V % P), L);
//            int result = ( V / P ) * L + option;
//
//            System.out.printf("Case %d: %d\n", a++, result);
//        }
    }
}
