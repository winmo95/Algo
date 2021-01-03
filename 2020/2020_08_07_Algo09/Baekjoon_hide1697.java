package com.ssafy.hw.day09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_hide1697 {
	
	static int N,K;
	static int Visit [] = new int[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		K = sc.nextInt();
		
		BFS();
	}

	private static int getN(int i,int nN) {
		switch(i) {
		case 0 : return nN+1;
		case 1:  return nN-1;
		case 2:  return nN*2;		
		}
		return -1;
	}
	private static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(N);
		Visit[N] = 1;
		int status[] = {-1,+1,2};
		while(!q.isEmpty()) {
			N =q.poll();
			if(N == K) break;
			for(int i=0;i<3;i++) {
				int nN = getN(i,N);
				if(nN <=100000 && nN >=0 &&Visit[nN] == 0) {
					q.add(nN);
					Visit[nN] = Visit[N]+1;
				}
			}
			
		}
		System.out.println(Visit[K]-1);
	}
}
