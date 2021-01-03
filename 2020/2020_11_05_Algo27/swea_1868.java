package com.ssafy.hw.day1105;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1868 {
	static char game[][];
	static boolean check[][];
	static int N,answer;
	static int dx[] = {-1,-1,0,1,1,1,0,-1};
	static int dy[] = {0,-1,-1,-1,0,1,1,1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=testCase;t++) {
			N = Integer.parseInt(br.readLine());
			answer = 0;
			game = new char[N][N];
			check = new boolean[N][N];
			for(int i=0;i<N;i++) {
				game[i] = br.readLine().toCharArray();
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(game[i][j]=='*') continue;
					getCount(i,j);
				}
			}
			
		//	System.out.println(answer);
	
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(game[i][j]=='.') answer++;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}


	private static void getCount(int x, int y) {

		int count = 0;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (game[nx][ny] == '*')
					count++;
			}
		}

		if (count == 0) {
			if(!check[x][y]) answer++;
			check[x][y] = true;
			game[x][y] = 'X';
			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (game[nx][ny] == '.') {
						check[nx][ny] = true;
						getCount(nx, ny);
					}
					game[nx][ny] = 'X';
				}
			}
		}
	}
			
		
		
		
		
		
		
	
	
}
