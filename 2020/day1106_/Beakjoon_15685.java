package com.ssafy.hw.day1106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Beakjoon_15685 {
	static boolean map[][] = new boolean[101][101];
	static int N;
	static int dx[]= {0,-1,0,1};
	static int dy[]= {1,0,-1,0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			List<Integer> list = new ArrayList<Integer>();
			DragonCurve(x,y,d,g,list);
		}
		System.out.println(getCount());
	}
	private static int getCount() {
		int count=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j]&&map[i+1][j]&&map[i][j+1]&&map[i+1][j+1])count++;
 			}
		}
		
		return count;
	}
	private static void DragonCurve(int x, int y, int d, int g, List<Integer> list) {
		Stack<Integer> s = new Stack<Integer>();
		list.add(d);
		for(int i=1;i<=g;i++) {
			for(int j : list) {
				s.add(j);
			}
			while(!s.isEmpty()) {
				int dir = s.pop();
				list.add((dir+1)%4);
			}	
		}
		
		makeCurve(x,y,list);
		
		
	}
	private static void makeCurve(int x, int y, List<Integer> list) {
		map[x][y] = true;
		int nx =x;
		int ny =y;
		for(int i=0;i<list.size();i++) {
			nx = nx+dy[list.get(i)];
			ny = ny+dx[list.get(i)];
			map[nx][ny]=true;
		}
	}
	
	
}
