package com.ssafy.hw.day23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4014 {
	static StringTokenizer st;
	static int N,X,map[][],answer =0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=testCase;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			answer = 0;
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			makeRoad();
			System.out.println("#"+tc+" "+answer);
		}
	}

	private static void makeRoad() {
		for(int i=0;i<N;i++) {
			if(isConst(i,true)) {
				answer++;
			}else {
				if(consWith(i,true)) {
					answer++;
				}
			}
			
			if(isConst(i,false)) {
				answer++;
			}else {
				if(consWith(i,false)) {
					answer++;
				}
			}
			
		}
		
	}

	//경사로 사용
	private static boolean consWith(int xx, boolean isRow) {
		
		int start=-1;
		if(isRow) {
			start = map[xx][0];
			if(!check(start,isRow,xx)) {
				return false;
			}
			
		}else {
			start = map[0][xx];
			if(!check(start,isRow,xx)) {
				return false;
			}
		}
		
		return true;
	}

	private static boolean check(int start, boolean isRow,int xx) {
		int before,size;

		size = 1;
		for(int j=1;j<N;j++) {
			if(isRow) {
				before = map[xx][j];
			}else {
				before = map[j][xx];
			}
			
			
			if(start==before) {
				++size;
			}else if(start +1== before) {
				if(size < X) return false;
				start++;
				size=1;
			}else if(start-1 == before) {
				int count=0;
				for(int k=j;k<N;k++) {
					int temp=0;
					if(isRow) {
						temp =map[xx][k];
					}else {
						temp = map[k][xx];
					}
					if(temp != start-1) {
						break;
					}
					count++;
				}
				if(count<X) return false;
				j += X-1;
				start--;
				size=0;
			}else {
				return false;
			}
		}
	
		return true;
	}
	//경사로 업이
	private static boolean isConst(int xx, boolean isRow) {
		int start = -1;
		
		if(isRow) {
			start = map[xx][0];
			for(int i=1;i<N;i++) {
				if(map[xx][i]!=start) return false;
			}
		}else {
			start = map[0][xx];
			for(int i=1;i<N;i++) {
				if(map[i][xx]!=start) return false;
			}
		}
		return true;
	}
}
