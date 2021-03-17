package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] prime;
    public static int primeCount;
    public static int[] notprimeCheck;
    public static void getPrime(int N) {
        for(int i = 2; i <= (N+1)/2; i++) {
            int count = 2;
            int num = i * count;
            while(num <= N) {
                notprimeCheck[num] = 1;
                num = i * (++count);
            }
        }
        for(int i = 2; i <= N; i++) {
            if(notprimeCheck[i] != 1) {
                prime[primeCount++] = i;

            }
        }
    }
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        prime = new int[N+1];
        notprimeCheck = new int[N+1];
        primeCount = 0;
        getPrime(N);
        int start = 0;
        int end =  0;
        int sum = 0;
        int result = 0;

        while(start <= primeCount && end <= primeCount) {
            if(sum < N) {
                sum += prime[end++];
            } else if (sum > N) {
                sum -= prime[start++];
            } else {            // sum == N
                result++;
                sum -= prime[start++];
            }
        }
        System.out.println(result);

    }
}
