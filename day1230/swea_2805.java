package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2805 {
	static StringTokenizer st;
	static int N; // 농장의 크기
	static int farm[][];  // 농장 수확물
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			farm = new int [N][N];
			for(int i=0;i<N;i++) {
				char temp[] = br.readLine().toCharArray();
				for(int j=0;j<N;j++) {
					farm[i][j] =(int)(temp[j]-'0');
				}
			}
			
			System.out.println("#"+tc+" "+getFarm());
		}
	}
	private static int getFarm() {
		int sum = 0;
		int start = N/2;  // 홀수 중앙값
		int left = start, right = start;  // left = 시작, right = 끝
		for(int i=0;i<N;i++) {   // 다이아 몬드 출력	
			for(int j=left;j<=right;j++) {   // left 와 right 사이의 수확물을 구한다
				sum += farm[i][j];
			}
			
			if(i < N/2) {  // 점점 커진다  
				left--;
				right++;
			}else {        // 점점 작아진다
				left++;
				right--;
			}
		}
		
		return sum;
	}
}
