package com.ssafy.hw.day1102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_5656 {
	static int N, W, H,answer = Integer.MAX_VALUE,map[][] ;
	private static int dropPoint[];
	static StringTokenizer st;
	static int dx[] = {0,-1,0,1};
	static int dy[] = {-1,0,1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			dropPoint = new int[N];
			answer = Integer.MAX_VALUE;
			map= new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			selectPoint(0);
			System.out.println("#"+t+" "+answer);
		}
	}

	private static void selectPoint(int cnt) {
		if(cnt==N) {
			playBall(dropPoint);
			return;
		}
		
		for(int i=0;i<W;i++) {
			dropPoint[cnt] = i;
			selectPoint(cnt+1);
		}
	}

	private static void playBall(int[] Point) {
		int temp[][] = CopyMap(map);

		int count=0;
		while(count<N) {
			for(int i=0;i<H;i++) {
				if(temp[i][Point[count]] != 0) {			
					temp = Break(temp,i,Point[count]);
					break;
				}
			}
			temp = Down(temp);
			count++;
		}
		
	}

	private static int[][] Down(int[][] temp) {
		Stack<Integer> s = new Stack<Integer>();
		int count=0;
		for (int a = 0; a < W; a++) {
			for (int b = 0; b < H; b++) {
				if(temp[b][a] !=0) {
					count++;
					s.add(temp[b][a]);
					temp[b][a]=0;
				}
			}
			int index = H - 1; 
			while (!s.isEmpty()) { 
				temp[index--][a] = s.pop(); 
			}
		}
		
		answer = Math.min(count, answer);
		return temp;
	}

	private static int[][] Break(int[][] temp, int x, int y) {
		int value = temp[x][y];

		if(value==1) {
			temp[x][y] = 0;
		}else {
			temp[x][y] = 0;
			for(int i=0;i<4;i++) {
				int nx = x;
				int ny = y;
				for(int j=0;j<value-1;j++) {
					nx += dx[i];
					ny += dy[i];
					if(nx>=0 && nx<H && ny>=0 && ny<W) {
						if(temp[nx][ny] !=0) {
							temp = Break(temp, nx, ny);
						}
					}
				}
				
				
			}
		}
		return temp;
	}

	private static int[][] CopyMap(int[][] origin) {
		int temp[][] = new int[H][W];
		for (int a = 0; a < H; a++) {
			System.arraycopy(origin[a], 0, temp[a], 0, W);
		}
		return temp;
	}
}
