package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    static int[] palin = new int[200_002];

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = 0;
        String temp = "";
        for(int i = 0; i < input.length(); i++) {
            temp += "#";
            temp += input.charAt(i);
        }
        temp += "#";
        palindrome(temp);

        for(int i = 0; i < temp.length(); i++) {
            result = Integer.max(result, palin[i]);
        }
        System.out.println(result);


    }

    public static void palindrome(String str) {
        int len = str.length();
        int center = 0, radius = 0;
        int mirror = 0;
        for(int i = 0; i < len; i++) {
            mirror = center * 2 - i;

            if (i <= radius) {
                palin[i] = Integer.min(palin[mirror], radius - i);
            } else {
                palin[i] = 0;
            }

            while (i - palin[i] - 1 >= 0 && i + palin[i] + 1 < len && str.charAt(i - palin[i] - 1) == str.charAt(i + palin[i] + 1)) {
                palin[i]++;
            }

            if (i + palin[i] > radius) {
                center = i;
                radius = i + palin[i];
            }

        }
    }
}