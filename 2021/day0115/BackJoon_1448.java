package day0115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 조합으로 푸니 시간초과
 * */
public class BackJoon_1448 {
	static int []number;
	static int N,max;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max = -1;                                        // 삼각형이 만들어지지 않을 때
		N =  Integer.parseInt(br.readLine());
		number = new int[N];
		for(int i=0;i<N;i++) {
			number[i] = Integer.parseInt(br.readLine());
		}
	
		Arrays.sort(number);                            // 오름차순으로 정렬 : 가장 큰 둘레를 가진 삼각형을 구해야하기 때문에
		for(int i = N-1; i>=2; i--) {
			if(number[i-2]+number[i-1] > number[i]) {          // 삼각형의 성립조건 가장 큰 변의 길이가 다른 두변의 길이의 합 보다 작아야한다
				max = number[i-2]+number[i-1]+number[i];       // 삼각형이 성립하기 때문에 세변의 길이의 합을 구한다
				break;											// 삼각형이면 반복문 종료
			}
		}
		
		System.out.println(max);
		
	}
}
