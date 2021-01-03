package com.ssafy.hw.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_startAndLink_14889 {
	static int N, ScoreMin = Integer.MAX_VALUE;
	static int map[][];
	static StringTokenizer st;
	static boolean select[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map=new int [N][N];
		select=new boolean [N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Solve(0,0);
		System.out.println(ScoreMin);
		
	}
	private static void Solve(int cnt, int selectNum) {
		// TODO Auto-generated method stub
		if(cnt>=N) return;
		if(selectNum == N/2) {
			List<Integer> start = new ArrayList<Integer>();
			List<Integer> link = new ArrayList<Integer>();
		
			for(int i =0;i<N;i++) {
				if(select[i]) {
					start.add(i);
				}else {
					link.add(i);
				}
			}
		
			int sum1 = 0, sum2 = 0;
			for (int k = 0; k < start.size(); k++) {
				for (int j = k+1; j < start.size(); j++) {
					sum1 += map[start.get(k)][start.get(j)] + map[start.get(j)][start.get(k)];
					sum2 += map[link.get(k)][link.get(j)] + map[link.get(j)][link.get(k)];
				}
			}
			ScoreMin = Math.min(ScoreMin, Math.abs(sum2 - sum1));			
			return;
			
		}
		
		select[cnt] = true;
		Solve(cnt+1,selectNum+1);
		
		select[cnt] = false;
		Solve(cnt+1,selectNum);
		
	}
}
