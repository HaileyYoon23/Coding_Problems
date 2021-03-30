package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[] lastYear;
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public static int[] numOfLine;
    public static int visited = 0;
    public static String result = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while((T--) > 0) {
            arr = new ArrayList<>();
            result = "";
            visited = 0;
            N = Integer.parseInt(br.readLine());
            lastYear = new int[N+1];
            numOfLine = new int[N+1];
            st = new StringTokenizer(br.readLine());
            arr.add(new ArrayList<Integer>());
            for(int i = 1; i <= N; i++) {
                lastYear[Integer.parseInt(st.nextToken())] = i;
                arr.add(new ArrayList<Integer>());
            }
            M = Integer.parseInt(br.readLine());
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(lastYear[a] > lastYear[b]) {         // 올해 등수 a 가 등수 크기 작음
                    arr.get(a).add(b);
                    numOfLine[b]++;
                } else {
                    arr.get(b).add(a);
                    numOfLine[a]++;
                }
            }
            for(int i = 1; i < N; i++) {
                for(int j = i+1; j <= N; j++) {
                    if(arr.get(i).contains(j) || arr.get(j).contains(i)) continue;
                    else {
                        if(lastYear[i] > lastYear[j]) {
                            arr.get(j).add(i);
                            numOfLine[i]++;
                        } else {
                            arr.get(i).add(j);
                            numOfLine[j]++;
                        }
                    }
                }
            }
            topologicalSort();

            if(visited != N ) sb.append("IMPOSSIBLE\n");
            else sb.append(result+"\n");
        }
        System.out.println(sb);
    }
    public static void topologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            if(numOfLine[i] == 0) {
                queue.add(i);
                visited++;
                numOfLine[i] = -1;
            }
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(queue.size() == 0) {
                result += node + " ";
            } else {
                result += "? ";

            }

            for(int next: arr.get(node)) {
                numOfLine[next]--;
            }
            for(int i = 1; i <= N; i++) {
                if(numOfLine[i] == 0) {
                    queue.add(i);
                    visited++;
                    numOfLine[i] = -1;
                }
            }
        }
    }

}
