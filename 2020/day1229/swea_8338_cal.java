package day1229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_8338_cal {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int answer = Integer.parseInt(st.nextToken());

			for (int i = 1; i < N; i++) { // 수 저장
				int num = Integer.parseInt(st.nextToken());
				answer = Math.max(answer*num, answer+num);
			}

			System.out.println("#" + tc + " " + answer);
		}
	}

//	static int answer,N; // 최대값
//	static int[] a; // 수
//	public static void main(String[] args) throws IOException{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int testCase = Integer.parseInt(br.readLine());
//		for(int tc = 1; tc <= testCase; tc++) {
//			N = Integer.parseInt(br.readLine());
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			a = new int [N+1]; // 수를 저장할 공간
//			answer = Integer.MIN_VALUE; // 정답 초기화
//			
//			for(int i = 1; i<=N; i++) { // 수 저장
//				a[i] = Integer.parseInt(st.nextToken());
//			}
//			
//			solution(0,a[0]); // 최대값 구하기
//			System.out.println("#"+tc+" "+answer);
//		}
//	}
//	
//	private static void solution(int idx, int sum) {
//		if(idx == N) { // 연산한 숫자의 갯수가 N개일 때
//			answer = Math.max(answer, sum);  //최대값 구하기
//			return ;
//		}
//		
//		// 곱하기
//		solution(idx+1, sum*a[idx+1]);
//		// 더하기
//		solution(idx+1, sum+a[idx+1]);
//		
//	}
}
