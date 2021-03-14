package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.valueOf(br.readLine());
        String s = br.readLine();
        int[] pi = piResult(s);

        System.out.println(s.length() - pi[s.length()-1]);


    }

    public static int[] piResult(String str) {
        int[] pi = new int[str.length()];
        int j = 0;
        for(int i = 1; i < str.length(); i++) {
            while(j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if(str.charAt(i) == str.charAt(j)) {
                j++;
                pi[i] = j;
            }
        }
        return pi;
    }
}
