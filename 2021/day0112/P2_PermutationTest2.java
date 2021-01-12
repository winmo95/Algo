package com.ssafy.live02;

import java.util.Arrays;
import java.util.Scanner;

public class P2_PermutationTest2 {
	
	private static int N=4,R=4;
	private static int[] numbers; //순열 저장 배열
	private static int[] input;  //입력된 숫자 배열
	private static boolean[] isSelected;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[N]; //   new int[R]
		isSelected = new boolean [N+1];
		input = new int[N];
		
		for(int i=0;i<N;i++) {
			input[i]= sc.nextInt();
		}
		permutation(0);
	}
	
	private static void permutation(int cnt) { //cnt : 현재까지 뽑은 순열의 갯수
		if(cnt==N) { // if(cnt==R) R: 뽑고 싶은 갯수 ex 4개중에 2(R)개 
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true; //해당숫자의 위치로 사용 처리
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}
