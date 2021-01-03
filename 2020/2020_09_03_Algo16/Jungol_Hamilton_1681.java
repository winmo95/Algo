package com.ssafy.hw.day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jungol_Hamilton_1681 {
	static int N,answer = Integer.MAX_VALUE , map[][];
	static StringTokenizer st;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visit[0] = true;
		Solve(0,0,1,0);
		System.out.println(answer);
		
	}
	private static void Solve(int start, int next, int count,int sum) {
		if(count == N) {
			if(map[next][start] == 0) return;
			answer = Math.min(answer, sum+map[next][start]);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visit[i] && map[next][i] != 0 ) {				
				visit[i] = true;
				Solve(start,i,count+1,sum+map[next][i]);
				visit[i] =false;
			}
		}
		
	}
	
	
}
