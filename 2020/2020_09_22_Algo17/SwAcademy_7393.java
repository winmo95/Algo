package com.ssafy.day20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwAcademy_7393 {
	static final int mod =1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TestCase;tc++) {
			int N = Integer.parseInt(br.readLine());
			int visit = 1<<10;
			long dp[][][] = new long [N+1][10][visit];
			long sum=0;
			
			for(int i=1;i<=9;i++) {
				dp[1][i][1<<i] =1;
			}
			
			for (int i = 2; i <= N; i++) { 
	            for (int j = 0; j <= 9; j++) { 
	                for (int k = 0; k < visit; k++) {
	                    int temp = k | (1 << j);
	                    if (j == 0) {
	                        dp[i][0][temp] = (dp[i][0][temp] + dp[i - 1][1][k]) % mod;
	                    } else if (j == 9) {
	                        dp[i][9][temp] = (dp[i][9][temp] + dp[i - 1][8][k]) % mod;
	                    } else {
	                        dp[i][j][temp] = (dp[i][j][temp] + dp[i - 1][j - 1][k]) % mod;
	                        dp[i][j][temp] = (dp[i][j][temp] + dp[i - 1][j + 1][k]) % mod;
	                    }
	                }
	            }
	        }
	 
	        for (int j = 0; j <= 9; j++) {
	        	sum = (sum + dp[N][j][visit - 1]) % mod;
	        }
	        
	        
			System.out.println("#"+tc+" "+sum);
		}
	}
}
