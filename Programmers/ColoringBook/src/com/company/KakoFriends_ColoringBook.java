package com.company;

import org.w3c.dom.Node;

import java.util.*;

public class KakoFriends_ColoringBook {

    public static void main(String[] args) {
        int[][] Array = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
        int m = 6;
        int n = 4;
        int[] result = new int[2];
        Solution s = new Solution();
        result = s.solution(m,n,Array);
        System.out.print(result[0] + " " + result[1]);
    }
}
class Point {
    int x;
    int y;
    public Point(int a, int b) {
        this.x = a;
        this.y = b;
    }
}

class Solution {
    static int[] dirRow = {-1,0,1,0};
    static int[] dirColumn = {0,1,0,-1};
    static boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        visited = new boolean[m][n];

        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                if(visited[x][y] || picture[x][y] == 0) continue;

                answer[0]++;
                answer[1] = Math.max(BFS(picture,new Point(x,y)),answer[1]);
            }
        }

        return answer;
    }

    static int BFS(int[][]pic, Point p) {
        Queue<Point> queue = new LinkedList<>();
        int area = 1;
        int curX, curY;

        visited[p.x][p.y] = true;
        queue.offer(p);
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            for(int i = 0; i < 4; i ++) {
                curX = current.x + dirRow[i];
                curY = current.y + dirColumn[i];

                if(curX >= 0 && curX < pic.length && curY >= 0 && curY < pic[0].length) {
                    if(!visited[curX][curY] && pic[curX][curY] != 0 && pic[current.x][current.y] == pic[curX][curY]) {
                        visited[curX][curY] = true;
                        queue.offer(new Point(curX, curY));
                        area++;
                    }
                }
            }
        }
        return area;
    }
}