package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static int[] palin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        ArrayList<String> temp = new ArrayList<>();
        for(int i = 0; i < str.length; i++) {
            temp.add("#");
            temp.add(str[i]);
        }
        temp.add("#");
        palin = new int[temp.size()];
        palidrome(temp);
        for(int m = 0; m < M; m++) {
            String[] cmd = br.readLine().split(" ");
            int start = Integer.parseInt(cmd[0]);
            int end = Integer.parseInt(cmd[1]);
            int len = end - start + 1;
            if(len % 2 == 0) {          // like 2 2
                if(len <= palin[start + end - 1]) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            } else {                    // list 1 2 1
                int mid = (start + end) / 2;
                if(len <= palin[mid * 2 - 1]) sb.append(1+"\n");
                else sb.append(0 + "\n");
            }
        }

        System.out.println(sb);
    }
    public static void palidrome(ArrayList<String> arr) {
        int len = arr.size();
        int center = 0, radius = 0, mirror = 0;
        for(int i = 0; i < len; i++) {
            mirror = center * 2 - i;

            if(i <= radius) {
                palin[i] = Integer.min(palin[mirror], radius - i);
            } else {
                palin[i] = 0;
            }

            while(i-palin[i]-1 >= 0 && i+palin[i]+1 < len &&
                    arr.get(i-palin[i]-1).equals(arr.get(i+palin[i]+1))) {
                palin[i]++;
            }

            if(i + palin[i] > radius) {
                center = i;
                radius = i + palin[i];
            }
        }
    }
}
