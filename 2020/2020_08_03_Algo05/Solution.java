package com.ssafy.day04;


import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for(int tc = 1;tc<=T;tc++) {
			int n = sc.nextInt();
			int max = sc.nextInt();
			int []arr = new int[n];
			
			int sum=0,MW=-1;
			for(int i=0;i<n;i++) arr[i] = sc.nextInt();
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					sum = arr[i]+arr[j];
					if(sum<=max && sum>MW) MW = sum;
				}
			}
		
			System.out.printf("#%d %d\n",tc,MW);
			//System.err.printf("#%d -1\n",tc);
		}
	}
}
