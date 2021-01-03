package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2563 {
	
	static int map[][];
	public static void main (String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int [101][101];
        
        for(int i=0;i<N;i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int x =  Integer.parseInt(st.nextToken());
        	int y =  Integer.parseInt(st.nextToken());
        	
        	for(int j=x;j<x+10;j++) {
        		for(int k=y;k<y+10;k++) {
        			if(map[j][k]==1) continue;
        			map[j][k]=1;
        		}
        	}
        }
        
      int sum =calc();
//        for(int i=1;i<=100;i++) {
//        	for(int j=1;j<=100;j++) {
//        		System.out.print(map[i][j]+" ");
//        	}
//        	System.out.println();
//        }
        System.out.println(sum);
    }
	
	static int calc() {
		int sum=0;
		for(int i=1;i<=100;i++) {
        	for(int j=1;j<=100;j++) {
        		if(map[i][j] != 0) {
        			sum++;
        			map[i][j]=7;
        		}
        	}
        }
		return sum;
	}


}
