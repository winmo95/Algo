package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BackJoon_2309 {
	static int [] boy,select;

	static final int N=9;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boy = new int [N];
		select = new int [7];

		for(int i=0;i<N;i++) {
			boy[i] = Integer.parseInt(br.readLine());
		}

		DFS(0,0);
		
	
	}
	private static void DFS(int cnt,int start) {
		// TODO Auto-generated method stub
		if(flag) return;
		if(cnt==7) {
			int sum=0;
			for(int i=0;i<7;i++) {
				sum += select[i];
			}
			if(sum==100) {
				Arrays.sort(select);
				for(int i=0;i<7;i++) {
					System.out.println(select[i]);
				}
				flag =true;
			}
			return ;
		}
		
		for(int i=start;i<N;i++) {
			select[cnt] = boy[i];
			DFS(cnt+1,start+1);
		}
		
	}
}
