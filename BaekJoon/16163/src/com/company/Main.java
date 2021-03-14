package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[] palin = new int[4_000_002];
    public static void main(String[] args) throws Exception{
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String temp = "";
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            temp += "#";
            temp += s.charAt(i);
        }
        temp += "#";

        palindrome(temp);

        for(int i = 0; i < temp.length(); i++) {
            if(palin[i] == 0) continue;
            result += (palin[i] + 1) / 2;
        }
        System.out.print(result);
    }

    public static void palindrome(String str) {
        int center = 0, radius = 0;
        int mirror = 0;
        int len = str.length();
        for(int i = 0; i < len; i++) {
            mirror = center * 2 - i;
            if (radius >= i) {
                palin[i] = Integer.min(radius - i, palin[mirror]);
            } else {
                palin[i] = 0;
            }

            while(i-palin[i]-1 >= 0 && i+palin[i]+1 < len && str.charAt(i-palin[i]-1) == str.charAt(i+palin[i]+1)) {
                palin[i]++;
            }

            if(i + palin[i] > radius) {
                center = i;
                radius = i + palin[i];
            }
        }
    }
}
