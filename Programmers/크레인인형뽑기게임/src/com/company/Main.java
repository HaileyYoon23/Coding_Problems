package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
	    int[] moves = {1,5,3,5,1,2,1,4};
	    System.out.println((new Solution()).solution(board,moves));
    }
}

class Solution {
    private static Queue<Integer>[] queues;
    private static Stack<Integer> stack = new Stack<>();
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        queues = new Queue[N];
        for(int i = 0; i < N; i++) queues[i] = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] != 0) {
                    queues[j].add(board[i][j]);
                }
            }
        }

        for(int m = 0; m < moves.length; m++) {
            if(queues[moves[m]-1].isEmpty()) {
                continue;
            } else {
                if(stack.isEmpty()) {
                    stack.add(queues[moves[m]-1].poll());
                } else {
                    int top = stack.peek();
                    int newDoll = queues[moves[m]-1].poll();
                    if(top == newDoll) {
                        stack.pop();
                        answer += 2;
                    }
                    else stack.add(newDoll);
                }
            }
        }

        return answer;
    }
}