package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> words = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String str = "";
        Trie trie = new Trie();
        float tempSum = 0;
        String firstInput = br.readLine();
        do{
            int N = Integer.valueOf(firstInput);
            str = "";
            for(int n = 0; n < N; n++) {
                str = br.readLine();
                trie.append(str + ".", 0);
                words.add(str);
            }
            for(int n = 0; n < N; n++) {
                tempSum += trie.calculateNeedInput(words.get(n), trie.child,0,0);
            }
            sb.append(String.format("%.2f\n", tempSum/N));
            trie = new Trie();
            words = new LinkedList<>();
            tempSum = 0;
            firstInput = br.readLine();
        }while(!firstInput.equals(""));

        System.out.println(sb.toString());
    }

}
class Trie {
    char alphabet;
    List<Trie> child = new ArrayList<>();

    public Trie() { }
    public Trie(char c) {
        this.alphabet = c;
    }
    public void append(String str, int index) {
        boolean isExist = false;
        if(index >= str.length()) return;
        for(Trie t: child) {
            if(t.alphabet == str.charAt(index)) {
                t.append(str, index + 1);
                isExist = true;
            }
        }
        if(!isExist) {
            child.add(new Trie(str.charAt(index)));
            if(index < str.length() - 1) {
                append(str, index);
            }
        }
    }

    public int calculateNeedInput(String str, List<Trie> paraT, int num, int count) {
        int result = num;
        if(str.length() == count) return result;
        if(paraT.size() == 1) {
            if (count == 0) result += 1;
            result = calculateNeedInput(str, paraT.get(0).child, result, count+1);
        }
        else {
            for(int i = 0; i < paraT.size(); i++) {
                Trie t = paraT.get(i);
                if(t.alphabet == str.charAt(count)) {
                    result++;
                    result = calculateNeedInput(str, t.child, result, count+1);
                    break;
                }
            }
        }
        return result;
    }
}

public class Main {
    static final int SIZE = 26;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            Trie trie = new Trie();
            int N = Integer.parseInt(line);
            String[] str = new String[N];

            for (int i = 0; i < N; i++) {
                str[i] = br.readLine();
                trie.insert(str[i]);
            }
            for (int i = 0; i < SIZE; i++) {
                if (trie.root.children[i] != null) {
                    trie.check(trie.root.children[i], 1);
                }
            }
            System.out.printf("%.2f", (double) cnt / N);
            System.out.println();
            cnt = 0;
        }
    }
}
