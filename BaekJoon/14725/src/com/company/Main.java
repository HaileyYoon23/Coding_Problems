package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        int rootCnt = 0;
        Trie trie = new Trie();

        for(int t = 0; t < T; t++) {
            String[] testLine = br.readLine().split(" ");
            trie.append(testLine, 1);
        }
        trie.print(0);
    }
}

class Trie {
    String room;
    List<Trie> child = new ArrayList<>();
    public Trie() {

    }
    public Trie(String r) {
        this.room = r;
    }
    public void append(String[] arr, int index) {
        boolean isExist = false;
        for(Trie t: child) {
            if(t.room.equals(arr[index])) {
                t.append(arr, index + 1);
                isExist = true;
            }
        }
        if(!isExist) {
            child.add(new Trie(arr[index]));
            if(index < arr.length - 1) {
                append(arr, index);
            }
        }
    }
    public void print(int i) {
        child.sort((lhs,rhs) -> {
                return lhs.room.compareTo(rhs.room);
                });
        for(Trie t: child) {
            for(int a = 0; a < i; a++) {
                System.out.print("--");
            }
            System.out.println(t.room);
            t.print(i+1);
        }
    }
}