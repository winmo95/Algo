package com.ssafy.hw.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_Alphbat_1987 {
	static int R,C;
	static char map[][];
	static boolean Alphbat[];

	static int dx[] = {-1,0,1,0}; // 상 , 좌, 하, 우
	static int dy[] = {0,-1,0,1};
	static int answer=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Alphbat = new boolean[26];
		map = new char[R][];
		
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		solve(0,0,0);
		System.out.println(answer);
	}
	
	private static void solve(int x, int y,int cnt) {
		if(Alphbat[map[x][y]-'A']) {
			answer = Math.max(answer, cnt);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(isOut(xx, yy)) {
				Alphbat[map[x][y]-'A'] = true;
				solve(xx, yy, cnt+1);
				Alphbat[map[x][y]-'A'] = false;
			}
		}
		
	}
	
	private static boolean isOut(int x,int y) {
		return (x>=0&&x<R&&y>=0&&y<C);
	}
}
