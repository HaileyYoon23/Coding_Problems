package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static class Stack {
        static int[] arr = new int[10_001];
        static int count;
        Stack() {
            count = 0;
        }

        static void push(int n) {
            arr[count++] = n;
        }
        static int pop() {
            return (count == 0) ? -1 : arr[--count];
        }
        static int size() {
            return count;
        }
        static int empty() {
            return (count == 0) ? 1 : 0;
        }
        static int top() {
            return (count == 0) ? -1 : arr[count-1];
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Stack s = new Stack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        String command = br.readLine();
        int result = 0;
        for(int i = 0; i < N; i++){
            String[] cmdList = command.split(" ");
            switch (cmdList[0]) {
                case ("push"):
                    Stack.push(Integer.valueOf(cmdList[1]));
                    break;
                case ("top"):
                    result = Stack.top();
                    break;
                case ("size"):
                    result = Stack.size();
                    break;
                case ("empty"):
                    result = Stack.empty();
                    break;
                case ("pop"):
                    result = Stack.pop();
                    break;
                default:
                    break;
            }
            if (!cmdList[0].equals("push")) {
                System.out.println(result);
            }

            command = br.readLine();
        }


    }
}

