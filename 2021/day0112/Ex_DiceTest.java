package com.ssafy.live02;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_DiceTest {

	private static int N,totalcnt;
	private static int []numbers;
	private static boolean [] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		isSelected = new boolean[7];
		totalcnt=0;
		int mode = sc.nextInt();
		switch(mode) {
		case 1: 
				dice1(0); //중복 순열
			break;
		case 2: dice2(0); //순열
			break;
		case 3: dice3(0,1); //중복조합
			break;
		case 4: dice4(0,1);  //조합
			break;
		}
		System.out.println("총 경우의 수 : "+totalcnt);
	}
	
	//cnt 주사위 던지기
	private static void dice1(int cnt) {  // cnt :현재까지 던진 주사위 수
		if(cnt==N) {
			++totalcnt;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=1;i<=6;i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
	}
	
	private static void dice2(int cnt) { // cnt :현재까지 던진 주사위 수
		if(cnt==N) {
			++totalcnt;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=1;i<=6;i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			dice2(cnt+1);
			isSelected[i] = false;
		}
	}

	private static void dice3(int cnt,int start) { //중복 조합 / cnt :현재까지 던진 주사위 수
		if(cnt==N) {
			++totalcnt;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start;i<=6;i++) {
			numbers[cnt] = i;
			dice3(cnt+1,i);
		}
	}
	
	private static void dice4(int cnt,int start) { //조합 / cnt :현재까지 던진 주사위 수
		if(cnt==N) {
			++totalcnt;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=start;i<=6;i++) {
			numbers[cnt] = i;
			dice4(cnt+1,i+1);
		}
	}
}
