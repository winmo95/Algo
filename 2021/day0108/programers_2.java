package day0108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class programers_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int fibo[] = new int [71];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i=2;i<=N;i++) {
			fibo[i] = fibo[i-2] + fibo[i-1];
		}
		
		System.out.println(fibo[N]);
	}
}
