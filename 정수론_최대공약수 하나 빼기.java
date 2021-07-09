package com.company;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] A;
    private static int[] leftGcd, rightGcd;
    private static int answer = -1, who;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        A = new int[N + 2];
        leftGcd = new int[N + 2];
        rightGcd = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1 ; i <= N ; i++) {
            leftGcd[i] = gcd(leftGcd[i - 1], A[i]);
        }
        for (int i = N ; i >= 1 ; i--) {
            rightGcd[i] = gcd(rightGcd[i + 1], A[i]);
        }
        for (int i = 1 ; i <= N ; i++) {
            int curGcd = gcd(leftGcd[i - 1], rightGcd[i + 1]);
            if (A[i] % curGcd == 0) continue;
            if (answer < curGcd) {
                answer = curGcd;
                who = A[i];
            }
        }
        if (answer == -1) {
            System.out.println(answer);
        }
        else {
            System.out.println(answer + " " + who);
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}

