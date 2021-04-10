package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "?????", "??????", "fro???", "pro?"};
        int[] result = (new Solution()).solution(words, queries);
        for(int r: result) System.out.print(r + " ");
    }
}

class Solution {
    public static int alphabetLen = 27;
    private static Trie frontTrieRoot = new Trie();
    private static Trie backTrieRoot = new Trie();
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int count = 0;
        for(String w: words) {
            insertTrie(w);
        }
        for(String q: queries) {
            int result = 0;
            if(wildCardFromBack(q) && wildCardFromFront(q)) {
                result = numberInArray(frontTrieRoot.lensInfo, q.length());
            } else {
                result = searchTrie(q, wildCardFromBack(q));
            }
            answer[count++] = result;
        }
        return answer;
    }

    private static boolean wildCardFromBack(String word) {
        if(word.charAt(word.length()-1) == '?') return true;
        return false;
    }
    private static boolean wildCardFromFront(String word) {
        if(word.charAt(0) == '?') return true;
        return false;
    }

    private static int searchTrie(String word, boolean startFromFront) {
        if(startFromFront) {
            Trie currentTrie = frontTrieRoot;
            int length = word.length();
            for(int i = 0; i < length && word.charAt(i) != '?'; i++) {
                if(currentTrie.childTrie[toNumber(word.charAt(i))] != null) {
                    currentTrie = currentTrie.childTrie[toNumber(word.charAt(i))];
                } else return 0;

            }
            return numberInArray(currentTrie.lensInfo, length);

        } else {
            Trie currentTrie = backTrieRoot;
            int length = word.length();
            for(int i = length - 1; i >= 0 && word.charAt(i) != '?'; i--) {
                if(currentTrie.childTrie[toNumber(word.charAt(i))] != null) {
                    currentTrie = currentTrie.childTrie[toNumber(word.charAt(i))];
                } else return 0;
            }
            return numberInArray(currentTrie.lensInfo, length);
        }
    }
    private static int numberInArray(Map<Integer, Integer> map, int number) {
        if(!map.containsKey(number)) return 0;
        return map.get(number);
    }
    private static void insertTrie(String word) {
        int length = word.length();
        Trie currentTrie = frontTrieRoot;
        for(int i = 0; i < length; i++) {
            int next = toNumber(word.charAt(i));
            if(currentTrie.childTrie[next] == null) {
                currentTrie.childTrie[next] = new Trie();
                currentTrie.nChild++;
            }
            insertLen(currentTrie.lensInfo, length);
            currentTrie = currentTrie.childTrie[next];
        }

        currentTrie = backTrieRoot;
        for(int i = length - 1; i >= 0; i--) {
            int next = toNumber(word.charAt(i));
            if(currentTrie.childTrie[next] == null) {
                currentTrie.childTrie[next] = new Trie();
                currentTrie.nChild++;
            }
            insertLen(currentTrie.lensInfo, length);
            currentTrie = currentTrie.childTrie[next];
        }

    }
    private static void insertLen(Map<Integer, Integer> map, int length) {
        if(map.containsKey(length)) {
            map.put(length, map.get(length) + 1);
        } else map.put(length, 1);
    }
    private static int toNumber(char c) {return c-'a';}
}

class Trie {
    Trie[] childTrie = new Trie[Solution.alphabetLen];
    int nChild;
    Map<Integer, Integer> lensInfo = new HashMap<>();
    Trie() {
        nChild = 0;
        for(int i = 0; i < Solution.alphabetLen; i++) childTrie[i] = null;
    }
}