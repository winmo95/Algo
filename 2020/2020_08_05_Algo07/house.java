package com.ssafy.ws.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class house {
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static int map[][];
	static boolean v[][];
	static int N;
	public static void DFS(int x,int y, int num) {
		if(!isOut(x, y)) return;
		v[x][y] = true;
		map[x][y] = num;
		for(int i=0;i<4;i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(isOut(xx, yy)) {
				DFS(xx,yy,num);
			}
		}
	}
	
	public static boolean isOut(int x,int y) {
		return( x>=0 && x<N && y>=0 && y<N && !v[x][y] &&map[x][y] == 1 );
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		for(int i=0;i<N;i++){
			String temp = br.readLine();
			for(int j=0;j<N;j++){
				map[i][j] = (int)(temp.charAt(j)-'0');
			}
		}
		int num =1;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(map[i][j]==1 && !v[i][j]) {
					DFS(i,j,num);
					num++;
				}
			}
		}
		System.out.println(num-1);
		int count[] = new int[num];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(map[i][j] != 0) count[map[i][j]]++;
			}
		}
		
		Arrays.sort(count);
		for(int i=1;i<=num-1;i++)
			System.out.println(count[i]);
//		for(int i=0;i<N;i++){
//			for(int j=0;j<N;j++){
//				System.out.printf("%d ",map[i][j]);
//			}System.out.println();
//		}
	}
}
