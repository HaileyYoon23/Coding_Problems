package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
    // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        numOfTen n_f = new numOfTen(numOf(n,2),numOf(n,5));
        numOfTen n_m_f = new numOfTen(numOf(n-m,2),numOf(n-m,5));
        numOfTen m_f = new numOfTen(numOf(m,2),numOf(m,5));
        numOfTen total = new numOfTen(n_f.numOfTwo - n_m_f.numOfTwo - m_f.numOfTwo,
                n_f.numOfFive - n_m_f.numOfFive - m_f.numOfFive);
        int result = Integer.min(total.numOfTwo, total.numOfFive);
        if(result < 0) System.out.print(0);
        else System.out.print(result);
    }
    public static int numOf(int N, long c) {
        int result = 0;
        long dupC = c;
        while(N >= dupC) {
            result += (N/dupC);
            dupC *= c;
        }
        return result;
    }
}
class numOfTen{
    int numOfTwo;
    int numOfFive;
    numOfTen(int t, int f) {
        this.numOfTwo = t;
        this.numOfFive = f;
    }
}
