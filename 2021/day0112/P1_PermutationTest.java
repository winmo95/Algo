package com.ssafy.live02;

import java.util.Arrays;

public class P1_PermutationTest {
	
	private static int N=4,R=3;
	private static int[] numbers;
	private static boolean[] isSelected;
	public static void main(String[] args) {
		numbers = new int[R]; //   new int[R]
		isSelected = new boolean [N+1];
		permutation(0);
	}
	
	private static void permutation(int cnt) { //cnt : 현재까지 뽑은 순열의 갯수
		if(cnt==R) { // if(cnt==R) R: 뽑고 싶은 갯수 ex 4개중에 2(R)개 
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=1;i<=N;i++) {
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}
