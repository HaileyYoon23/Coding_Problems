package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"go","gone","guild"};
        System.out.println((new Solution()).solution(words));
    }
}

class Solution {
    public static int MAX_SIZE = 26;
    public int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        for(int i = 0; i < words.length; i++) {
            answer += trie.search(words[i]);
        }
        return answer;
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    private int toNumber(char c) {return c - 'a';}

    void insert(String key) {
        int length = key.length();
        TrieNode currentNode = root;
        currentNode.isTerminal = false;
        for(int i = 0; i < length; i++) {
            int next = toNumber(key.charAt(i));

            if(currentNode.children[next] == null) {
                currentNode.children[next] = new TrieNode();
                currentNode.children[next].isTerminal = true;
                currentNode.nChild++;
            } else if(currentNode.nChild != 0) currentNode.isTerminal = false;
            currentNode = currentNode.children[next];
        }
        currentNode.nChild++;
        currentNode.isTerminal = true;
    }
    int search(String pattern) {
        int length = pattern.length();
        TrieNode currnetNode = root;
        for(int i = 0; i < length; i++) {
            int next = toNumber(pattern.charAt(i));
            if(currnetNode.isTerminal && currnetNode.nChild < 2) return i;
            currnetNode = currnetNode.children[next];
        }
        return length;
    }

//    void check(TrieNode node, int ret) {
//        if(node.isTerminal)
//    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[Solution.MAX_SIZE];
    boolean isTerminal;
    int nChild = 0;
    TrieNode() {
        isTerminal = false;
        for(int i = 0; i < Solution.MAX_SIZE; i++) {
            children[i] = null;
        }
    }
}