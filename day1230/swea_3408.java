package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_3408 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		/*
		 *  수학적 공식을 사용한 문제, 공식을 사용하지 않으면 시간초과 발생
		 *  N개의 숫자의 합(S1) : {N * (N-1)} / 2
		 *  N개의 홀수의 합(S1) : {N * (N-1)} - N
		 *  N개의 짝수의 합(S1) : N * (N-1)
		 *  
		 * */
		for (int tc = 1; tc <= testCase; tc++) {
			long N =  Integer.parseInt(br.readLine());
			long same = N * (N+1);  // 공통으로 들어가는 수식
			long s1=0,s2=0,s3=0;
			s1 = same/2; // 숫자의 합
			s2 = same-N; // 홀수의 합
			s3 = same;   // 짝수의 합
			
			System.out.println("#"+tc+" "+s1+" "+s2+" "+s3);
		}
		
		
		
	}
}
