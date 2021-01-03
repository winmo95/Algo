package com.ssafy.ws.day02;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(),N,M;
		
		for(int testCase =1;testCase<=T;testCase++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int max=0;
			int map[][] = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
		
			for(int i=0;i<N-M+1;i++) {
				for(int j=0;j<N-M+1;j++) {
					int answer= 0;
					for(int x=i;x<i+M;x++) {
						for(int y=j;y<j+M;y++) {
							answer+=map[x][y];
						}
					}
					if(answer>max) max = answer;
				}
			}
			
			System.out.printf("#%d %d\n",testCase,max);
			
		}
	}
}
