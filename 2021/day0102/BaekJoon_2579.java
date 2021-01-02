package day0102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_2579 {
	static int stair; 		// 계단 갯수
	static int score[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stair = Integer.parseInt(br.readLine());
		score = new int[stair+1];
		int dp[] = new int[stair+1];

		
		for(int i=1;i<=stair;i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		if(stair == 1 ) {            			// 계단이 1개 일때
			System.out.println(score[1]);
			return;
		}
		if(stair == 2 ) {            			// 계단이 2개 일때
			System.out.println(score[1]+score[2]);
			return;
		}
		if(stair == 3 ) {            			// 계단이 3개 일때 
			System.out.println(Math.max(score[1]+score[2], score[1]+score[3])); 
			return;
		}
		
		/*  동적 계획을 사용하여 문제 해결 // 재귀 사용시 시간 초과
		 * 다음 계단으로 갈 수 있는 방법
		 * 1.dp[i] =  dp[i-2]+score[i]   
		 *  : 현재 계단에서 2 칸 아래에서 2계단 뛰기
		 * 2.dp[i] =  dp[i-3] + score[i-1]+score[i]
		 *  : 현재 계단기준 3칸 아래에서 2계단 뛰고 1계단 뛴다 (세 칸 연속으로 밟을 수 없기 때문에)
		 * */
		
		dp[1] = score[1];
		dp[2] = score[1]+score[2];
		dp[3] = Math.max(score[1]+score[3], score[2]+score[3]);
		
		for(int i=4;i<=stair;i++) {
			dp[i] = Math.max(dp[i-2]+score[i], dp[i-3] + score[i-1]+score[i]);
		}
		
		System.out.println(dp[stair]);
	}
	

}
