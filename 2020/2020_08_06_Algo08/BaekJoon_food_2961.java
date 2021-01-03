package com.ssafy.hw.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_food_2961 {
	static int []S,B;
	static boolean use[];
	static int N,min=99999;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		use = new boolean[N];
		for(int i=0;i<N;i++) {
			StringTokenizer stt = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(stt.nextToken());
			B[i] = Integer.parseInt(stt.nextToken());
		}
		call(0,0,1,0);
		System.out.println(min);
	}
	
	
	public static void call(int cnt,int idx,int mul,int sum) {
		if(cnt>=1) {
			int result = Math.abs(mul - sum);
			if(min>result) min=result;
		}
		
		for(int i=idx;i<N;i++) {
			if(use[i]) continue;
			use[i] = true;
			call(cnt+1,i,mul*S[i],sum+B[i]);
			use[i] = false;
		}
	}
}
