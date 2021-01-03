package IM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class BackJoon_2635 {
	static int num;
	static int map[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max=0;
		List<Integer> result = new ArrayList<Integer>();
		for(int i=N-1;i>N/2;i--) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(N);
			int fn2 = N;
			int fn1 = i;
			while(true) {
				if(fn2 <0) break;
				int temp = fn2;
				if(fn1 >= 0) list.add(fn1);
				fn2 = fn1;
				fn1 = temp - fn2;
			}
			if(max < list.size()) {
				max = list.size();
				result = list;
			}
			
		}
		System.out.println(max);
		for(int num : result) {
			System.out.print(num+" ");
		}
	}
}
