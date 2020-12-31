package day1231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class swea_5215 {
	static StringTokenizer st;
	static int answer,N,L, score[], cal[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			score = new int[N];       // 점수를 저장할 배열
	        cal = new int[N];         // 칼로리를 저장할 배열
	        answer = Integer.MIN_VALUE;    // 정답
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
				
			}
		
			Solve(0,0,0);  //부분집합 사용
			System.out.println("#"+tc+" "+answer);
		}
	}
	private static void Solve(int cnt, int CTotal, int totalScore) {  // 부분집합으로 해결
		if(CTotal > L) return; // 제한 칼로리를 초과하면 안된다
		if(cnt == N) {         // 주어진 재료만큼 결정을 했으면 최대 점수 선택
			answer = Math.max(answer, totalScore); // 최대값 
			return;
		}
		
		Solve(cnt+1, CTotal, totalScore);  // 해당 재료를 선택하지 않는다
		Solve(cnt+1, CTotal+cal[cnt], totalScore+score[cnt]);  // 해당 재료를 선택한다
		
	}
}
