package com.ssafy.hw.day22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swAcademy5607 {
	static StringTokenizer st;
	private static final int MOD = 1234567891;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=testCase;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); 
			int R = Integer.parseInt(st.nextToken());
			long fac[] = new long[N+1];
			
			fac[0]=1;
			for(int i=1;i<=N;i++) {
				fac[i] = (fac[i-1] *i) %MOD;
			}
			
			long mom = (fac[R] * fac[N-R])%MOD;
			mom = fermat(mom, MOD -2 );

			System.out.println("#"+tc+" "+(fac[N] * mom) % MOD);
		}
	}

	private static long fermat(long p, int x) {
		if(x==0) return 1;
		long temp = fermat(p, x/2);
		long ret = temp*temp %MOD;
		if(x%2==0) return ret;
		else return ret*p%MOD;
	}
	
	
}
