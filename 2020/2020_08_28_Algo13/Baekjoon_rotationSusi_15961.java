package com.ssafy.hw.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_rotationSusi_15961{
	static int N,d,k,c,answer=Integer.MIN_VALUE;
	static int susi[];
	 
		public static void main(String[] args) throws  IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			susi = new int[N];
			int rotation[] = new int [d+1];
			int count=0,max=Integer.MIN_VALUE;
			Queue<Integer> eat = new LinkedList<Integer>();
			for(int i=0;i<N;i++) susi[i] = Integer.parseInt(br.readLine());
			
			for(int i=0;i<k;i++) {
				if(rotation[susi[i]]==0) {
					count++;
				}
				eat.offer(susi[i]);
				rotation[susi[i]]++;
			}
			if(rotation[c]==0) count++;
			max = Math.max(max, count);
//			for(int i : eat) System.out.print(i+" ");
//			System.out.println();
			if(rotation[c]==0) count--;
			
			for(int i=k;i<N;i++) {
				int first = eat.poll();
				int now =susi[i];
				eat.offer(now);
				
				if(rotation[now]++ == 0) {
					count++;
				}
				
				if(--rotation[first] ==0 ) {
					count--;
				}
				
				if(rotation[c]==0) count++;
				max = Math.max(max, count);
				if(rotation[c]==0) count--;
			}
			
			for(int i=0;i<k-1;i++) {
				int first = eat.poll();
				int now =susi[i];
				eat.offer(now);
				if(rotation[now]++ == 0) {
					count++;
				}
				
				if(--rotation[first] ==0 ) {
					count--;
				}
				if(rotation[c]==0) count++;
				max = Math.max(max, count);
				if(rotation[c]==0) count--;

			}
			System.out.println(max);
			
			
		}
		
	}
