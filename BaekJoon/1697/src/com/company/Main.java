package com.company;

import javax.swing.text.html.ListView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static Queue<Location> queue = new LinkedList<>();
    public static int N, K;
    public static boolean[] visitied = new boolean[100_001];
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        K = Integer.parseInt(info[1]);
        queue.add(new Location(N, 0));
        visitied[N] = true;
        System.out.println(BFS());
    }
    public static int BFS() {
        while(!queue.isEmpty()) {
            Location node = queue.poll();
            int x = node.x;
            int t = node.time;
            if(x == K) return t;
            if(x > 0 && !visitied[x-1]) {
                visitied[x-1] = true;
                queue.add(new Location(x-1,t+1));
            }
            if(x < 100_000 && !visitied[x+1]) {
                visitied[x+1] = true;
                queue.add(new Location(x+1,t+1));
            }
            if(x <= 50_000 && !visitied[2*x]) {
                visitied[2*x] = true;
                queue.add(new Location(2 * x,t+1));
            }

        }
        return -1;
    }
}

class Location {
    int x;
    int time;
    Location(int x, int t) {
        this.x = x;
        this.time = t;
    }
}