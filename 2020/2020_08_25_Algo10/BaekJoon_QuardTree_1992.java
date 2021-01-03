package com.ssafy.hw.day12_DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_QuardTree_1992 {
	static int map[][];
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			char [] tmp = br.readLine().toCharArray();
			for(int j = 0;j<N;j++) {
				map[i][j] = (int)(tmp[j]-'0');
			}
		}
		
		compression(0,0,N);
//		for(int i=0;i<N;i++) {
//			for(int j = 0;j<N;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(sb.toString());
	}
	
	private static void compression(int x, int y, int size) {
		// TODO Auto-generated method stub
		if(isAble(x,y,size)) {
			sb.append(map[x][y]);
		}else {
			sb.append("(");
			int newSize = size/2;
			
			compression(x, y, newSize);
			compression(x, y+newSize, newSize);
			compression(x+newSize, y, newSize);
			compression(x+newSize, y+newSize, newSize);
			
			sb.append(")");
		}
	}

	private static boolean isAble(int x,int y,int size) {
		int t = map[x][y];
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(t != map[i][j]) return false;
			}
		}
		return true;
		
	}
}
