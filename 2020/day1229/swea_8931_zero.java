package day1229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// Stack을 활용한 문제
public class swea_8931_zero {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 1;tc<=testCase;tc++) {
			
			// 변수를 자장할 스택
			Stack<Integer> s = new Stack<Integer>();
			int K = Integer.parseInt(br.readLine());
			
			for(int i = 0 ; i < K; i++) {
				// 받아 적은 수
				int num = Integer.parseInt(br.readLine());
				
				if(num==0) { // 0일 경우 지우기
					s.pop();
				}else { // 수 받아 적기
					s.push(num);
				}
			}
			
			
			int sum = 0;
			// 받아 적은 수의 합 계산
			while (!s.isEmpty()) {
				sum+=s.pop();
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
