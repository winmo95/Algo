package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_2304 {
	static int N,lenIndex,minIndex,maxIndex;
	static StringTokenizer st;
	static int build[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int maxlen=0;
		build = new int [1001];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if(maxlen < len) {
				lenIndex = x;
				maxlen = len;
			}
			minIndex = Integer.min(minIndex,x);
			maxIndex = Integer.max(maxIndex,x);
			build[x] = len;
		}
		
	
		System.out.println(maxlen+right()+left());
		
	}
	
	static int right() {
		int sum=0,h=0;
		for(int i=maxIndex;i>lenIndex;i--) {
			h = Integer.max(h, build[i] );
			sum+=h;
		}
		return sum;
	}
	static int left() {
		int sum=0,h=0;
		for(int i=minIndex;i<lenIndex;i++) {
			h = Integer.max(h,build[i]);
			sum+=h;
		}
		return sum;
	}
}
