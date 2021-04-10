package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int n = 16;
	    int t = 16;
	    int m = 2;
	    int p = 1;
	    System.out.println((new Solution()).solution(n,t,m,p));
    }
}

class Solution {
    public String solution(int n, int t, int m, int p) {
        String result = "";
        String answer = "";
        int len = t*m;
        int count = 0;
        while(result.length() <= len) {
            result = result + getNum(count++,n);
        }
        for(int i = p-1; i < len; i+= m) {
            answer = answer + result.substring(i,i+1);
        }
        return answer;
    }
    private static String getNum(int n, int base) {
        if(n < 2) return n+"";
        int temp = n;
        String result = "";
        while(temp > 0) {
            int mod = temp % base;
            if(mod >= 10) {
                result = Character.toString(mod + 'A' - 10) + result;
            } else result = mod + result;
            temp /= base;
        }
        return result;
    }
}