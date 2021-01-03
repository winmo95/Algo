package com.ssafy.hw1030;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1952 {
	static int month[], table[];
	static StringTokenizer st;
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			month = new int[16];
			table = new int[4];
			min = 0;
			for (int i = 0; i < 4; i++) {
				table[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				int day =  Integer.parseInt(st.nextToken());
				month[i+2] = Math.min(day*table[0], table[1]);
				min +=month[i+2];
			}
			
			ticket(0,min);
			System.out.println("#"+tc+" "+Math.min(min, table[3]));
		}
	}

	private static void ticket(int start, int sumMin) {
		// TODO Auto-generated method stub
		min = Math.min(sumMin, min);
		for(int i=start;i<14;i++) {
			int sum = month[i]+month[i+1]+month[i+2];
			if(sum > table[2]) {
				ticket(i+3, sumMin-sum+table[2]);
			}
			ticket(i+1, sumMin);
		}
		
	}
}
