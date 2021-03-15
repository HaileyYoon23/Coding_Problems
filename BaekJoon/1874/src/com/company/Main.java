package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[] result = new int[200_002];
    static class Stack {
        static int[] arr = new int[100_001];
        static int count;
        Stack() {
            count = 0;
        }
        static void push(int n) {
            arr[count++] = n;
        }
        static int pop() {
            int result = (count == 0) ? -1 : arr[--count];
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
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Stack s = new Stack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int N = Integer.valueOf(str);
        int curNum = 1;
        int resultCnt = 0;
        boolean isValid = true;
        for(int i = 0; i < N; i ++){
            int value = Integer.valueOf(br.readLine());
            int top = Stack.top();
            if(top == value) {
                Stack.pop();
                result[++resultCnt] = -1;       // pop
            } else {
                if(curNum > value) {
                    isValid = false;
                    break;
                } else {
                    while(Stack.top() != value) {
                        Stack.push(curNum++);
                        result[++resultCnt] = 1;   // push
                    }
                    Stack.pop();
                    result[++resultCnt] = -1;       // pop
                }
            }


        }
        if(Stack.empty() == 0) isValid = false;
        if(!isValid) { System.out.println("NO");}
        else {
            for(int a = 1; a <= resultCnt; a++) {
                if(result[a] == 1) {
                    System.out.println("+");
                } else {
                    System.out.println("-");
                }
            }

        }
    }
}

