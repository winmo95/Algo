package com.ssafy.hw.day02;

import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T,N;
		int map[][];
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new int[N][N];
			int x=0,y=-1;
			int dir =1,num=1;
			int col = N;
			while(true) {
				for(int i=0;i<col;i++) { //행
					y += dir; 
					map[x][y]=num++;
				}
					
				col--;
				if(col<=0) break;
				for(int i=0;i<col;i++) { //열
					x += dir; 
					map[x][y]=num++;
				}
				dir *=-1;
			}
			System.out.printf("#%d\n",test_case);
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					System.out.printf("%d ",map[i][j]);
				}System.out.println();
			}
		}
	}
}
