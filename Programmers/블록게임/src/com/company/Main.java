package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    int[][] board = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,4,0,0,0},{0,0,0,0,0,4,4,0,0,0},
                {0,0,0,0,3,0,4,0,0,0},{0,0,0,2,3,0,0,0,5,5},
                {1,2,2,2,3,3,0,0,0,5},{1,1,1,0,0,0,0,0,0,5}};

	    System.out.println((new Solution()).solution(board));
    }
}

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        return answer;
    }
}
