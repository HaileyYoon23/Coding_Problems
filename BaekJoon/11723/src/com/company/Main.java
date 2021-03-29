package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int arrNum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            String[] cmd = br.readLine().split(" ");
            int x;
            switch(cmd[0]) {
                case("add"):
                    x = Integer.parseInt(cmd[1]);
                    arrNum |= (1 << x);
                    break;
                case("remove"):
                    x = Integer.parseInt(cmd[1]);
                    arrNum &= ~(1 << x);
                    break;
                case("check"):
                    x = Integer.parseInt(cmd[1]);
                    sb.append(((arrNum >> x) & 1) + "\n");
                    break;
                case("toggle"):
                    x = Integer.parseInt(cmd[1]);
                    arrNum ^= (1 << x);
                    break;
                case("all"):
                    ALL();
                    break;
                case("empty"):
                    EMPTY();
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
     }
    public static void ALL() {
        arrNum = 0xFFFFFF;
    }
    public static void EMPTY() {
        arrNum = 0;
    }
}
