package com.ssafy.hw1104;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5643 {
	static int N,M,map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testCase;t++) {
			StringTokenizer st;
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[b][a] = 1;
				map[a][b] = -1;
				
				check(a,b);
				
			}
			int cnt=0;
			for(int i=1;i<=N;i++) {
				boolean youKnow = false;
				for(int j=1;j<=N;j++) {
			//		System.out.printf("%2d",map[i][j]);
					if(i==j) continue;
					if(map[i][j]==0) {
						
						youKnow = true;
						break;
					}
				}
			//	System.out.println();
				if(!youKnow) cnt++;
			}
			System.out.println("#"+t+" "+cnt);
		}
		
	}
	private static void check(int a, int b) {
		for(int i=1;i<N;i++) {
			if(map[a][i] == 1 && map[i][b] == 0) {
				map[b][i] = 1;
				map[i][b] = -1;			
				check(i, b);
			}
		}
		
		for(int i=1;i<N;i++) {
			if(map[b][i] == -1 && map[i][a] == 0) {
				map[a][i] = -1;
				map[i][a] = 1;
				check(i, a);
			}
		}
		
	}
	
}
