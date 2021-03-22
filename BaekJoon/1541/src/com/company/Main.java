package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int a = 0;
        int sum = 0;
        boolean minusShowed = false;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(minusShowed) {
                if(c>='0' && c<='9') {
                    a = a*10 + c - '0';
                } else{
                    sum -= a;
                    a = 0;
                }
            } else {
                if(c>='0' && c<='9') {
                    a = a*10 + c - '0';
                } else{
                    sum += a;
                    if(c == '-') {
                        minusShowed = true;
                    }
                    a = 0;
                }
            }
        }
        if(minusShowed) {
            sum -= a;
        } else {
            sum += a;
        }
        System.out.println(sum);
    }
}
