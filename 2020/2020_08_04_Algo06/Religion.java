package com.ssafy.ws.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Religion {
	static int person[];
	public static int find(int x) {
		if(person[x]==x)return x;
		else return person[x] = find(person[x]);
	}
	
	public static void union(int x,int y) {
		int xx =find(x);
		int yy = find(y);
		if(xx != yy) {
			person[yy] = xx;
		}
	}
	
	public static boolean same(int i) {
		if(person[i] == i) return true;
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		person = new int[n+1];
		for(int i=1;i<=n;i++) {
			person[i] = i;
		}
		
		for(int i =0;i<m;i++) {
			StringTokenizer stt = new StringTokenizer(br.readLine());
			union(Integer.parseInt(stt.nextToken()), Integer.parseInt(stt.nextToken()));
		}
		
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			if(same(i)) cnt++;
		}
		System.out.println(cnt);
	}
}
