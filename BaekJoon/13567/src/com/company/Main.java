package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[] dirI = {1,0,-1,0};
    public static int[] dirJ = {0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int curI = 0, curJ = 0, curDir = 0;
        boolean isValid = true;
        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            switch (command) {
                case("MOVE"):
                    curI += dirI[curDir] * value;
                    curJ += dirJ[curDir] * value;
                    break;
                case("TURN"):
                    if(value == 0) {        // TURN LEFT
                        curDir = (curDir + 3) % 4;
                    } else {
                        curDir = (curDir + 1) % 4;
                    }
                    break;
                default:
                    break;
            }
            if(curI < 0 || curI >= N || curJ < 0 || curJ >= N) {
                isValid = false;
                break;
            }
        }
        if(isValid) System.out.println(String.format("%d %d",curI, curJ));
        else System.out.println(-1);
    }
}
