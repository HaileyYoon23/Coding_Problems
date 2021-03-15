package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static class Stack {
        static int[] arr = new int[100_001];
        static int count;
        static int sum;
        Stack() {
            count = 0;
            sum = 0;
        }
        static void push(int n) {
            arr[count++] = n;
            sum += n;
        }
        static int pop() {
            int result = (count == 0) ? -1 : arr[--count];
            sum -= result;
            return result;
        }
        static int size() {
            return count;
        }
        static int empty() {
            return (count == 0) ? 1 : 0;
        }
        static int top() {
            return (count == 0) ? 0 : arr[count-1];
        }
        static int sum() {
            return sum;
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Stack s = new Stack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());

        int result = 0;
        for(int i = 0; i < N; i++){
            int value = Integer.valueOf(br.readLine());
            switch (value) {
                case (0):
                    Stack.pop();
                    break;
                default:
                    Stack.push(value);
                    break;
            }
        }
        System.out.println(Stack.sum());
    }
}

