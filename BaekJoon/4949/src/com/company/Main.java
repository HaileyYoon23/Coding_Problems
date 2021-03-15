package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
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

        int result = 0;
        String brackets = br.readLine();
        boolean isValid = true;
        do {
            s = new Stack();
            for(int i = 0; i < brackets.length(); i++) {
                isValid = true;
                switch (brackets.charAt(i)) {
                    case ('('):
                        Stack.push(1);
                        break;
                    case (')'):
                        if(Stack.top() == 1) {
                            Stack.pop();
                        } else {
                            isValid = false;
                            i = brackets.length();
                        }
                        break;
                    case ('['):
                        Stack.push(2);
                        break;
                    case (']'):
                        if(Stack.top() == 2) {
                            Stack.pop();
                        } else {
                            isValid = false;
                            i = brackets.length();
                        }
                        break;
                    default:
                        break;
                }
            }
            if(Stack.empty() == 0) isValid = false;
            if(isValid) { System.out.println("yes");}
            else {System.out.println("no");}
            brackets = br.readLine();
        } while(!brackets.equals("."));
    }
}

