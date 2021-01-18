package day0118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1915 {
	static int n,m,map[][], dp[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dp = new int [n+1][m+1];
		int len = 0;
		for(int i=0;i<n;i++) {
			char [] temp = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				dp[i+1][j+1] = temp[j]-'0';
				if(dp[i+1][j+1] != 0) {
					int num = Math.min(dp[i][j], dp[i][j+1]);
					dp[i+1][j+1] = Math.min(num, dp[i+1][j])+1;
					len = Math.max(len, dp[i+1][j+1]);
				}
			}
		}
		
		System.out.println(len*len);
	}
	
	
	private static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
