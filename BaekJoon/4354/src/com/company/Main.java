package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int[] result = new int[20];
        int count = 0;
        do{
            input = br.readLine();
            if (input.equals(".")) break;
            if (input.equals("")) result[count++] = 0;
            else result[count++] = (input.length())/(Solution(input).length());

        }while(!input.equals("."));

        for(int a = 0; a < count; a++) {
            System.out.println(result[a]);
        }
    }

    public static String Solution(String str) {
        String jtr = "";
        int j = 0;
        jtr = str.substring(0,1);
        for(int i = 0; i < str.length(); i ++) {
            if(j >= jtr.length()) j = 0;
            if(str.charAt(i) == jtr.charAt(j)) {
                j++;
                continue;
            } else {
                if (str.charAt(i) == jtr.charAt(0)) {
                    jtr += str.substring(jtr.length(),i);
                    i -= 1;
                    j = 0;
                } else {
                    jtr += str.substring(jtr.length(),i+1);
                    j = 0;
                }
            }
        }
        if (j != jtr.length()) {
            jtr += str.substring(jtr.length(),str.length());
        }
//        System.out.println(jtr);
        return jtr;
    }
}
