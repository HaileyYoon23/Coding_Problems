package com.company;

import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[] linkedLinesToMe;
    private static Work[] workList;
    private static Queue<Node> queue = new LinkedList<>();
    private static long minTime = 0;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    linkedLinesToMe = new int[N + 1];
        workList = new Work[N + 1];

        int[] inputsFirst = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        workList[1] = new Work(inputsFirst[0], 0);

	    for(int i = 2; i <= N; i++) {
	        int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
	        workList[i] = new Work(inputs[0], 0);
	        for(int k = 2; k <= inputs[1] + 1; k++) {
	            workList[inputs[k]].nextWork.add(i);
	            linkedLinesToMe[i]++;
            }
        }
	    // first zeroLine check
        for(int i = 1; i <= N; i++) {
            if(linkedLinesToMe[i] == 0) {
                queue.add(new Node(i, workList[i].time));
            }
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            minTime = Long.max(minTime, node.accTime);
            for(int next: workList[node.myNum].nextWork) {
                linkedLinesToMe[next] -= 1;
                if(linkedLinesToMe[next] == 0) {
                    queue.add(new Node(next, Integer.max(node.accTime, workList[next].accTime) + workList[next].time));
                } else {
                    workList[next].accTime = Integer.max(workList[next].accTime, node.accTime);
                }
            }
        }
        System.out.println(minTime);
    }
}

class Work {
    ArrayList<Integer> nextWork = new ArrayList<>();
    int time;
    int accTime;
    Work(int time, int accTime) {
        this.time = time;
        this.accTime = accTime;
    }
}

class Node {
    int myNum;
    int accTime;
    Node(int myNum, int accTime) {
        this.myNum = myNum;
        this.accTime = accTime;
    }
}
