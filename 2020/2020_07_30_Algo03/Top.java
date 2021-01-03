package com.ssafy.hw.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stt = new StringTokenizer(br.readLine());
		int height;
		Stack<int []> s = new Stack<int[]>();
		for(int i=1;i<=n;i++) {
			height = Integer.parseInt(stt.nextToken());
			while(!s.isEmpty()) {
				if(s.peek()[1] >= height) {
					System.out.print(s.peek()[0]+" ");
					break;
				}
				s.pop();
			}
			
			if(s.isEmpty()) System.out.print("0 ");
			s.push(new int[] {i,height});
		}
		
	}
}
