package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int check = 0;
        boolean isValid = true;
        for(int i = 0; i < N; i++) {
            String brackets = br.readLine();
            check = 0;
            isValid = true;
            for(int j = 0; j < brackets.length(); j++) {
                switch (brackets.charAt(j)) {
                    case ('('):
                        check++;
                        break;
                    case (')'):
                        check--;
                        break;
                    default:
                        break;
                }
                if(check < 0) {
                    isValid = false;
                    break;
                }
            }
            if(check != 0) {
                isValid = false;
            }
            if(isValid) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
