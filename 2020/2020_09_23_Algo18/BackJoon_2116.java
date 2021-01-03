package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2116 {
	static StringTokenizer st;
	static int diec[][];
	static int N,answer,total;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
 		diec=new int [N][6];
 		
 		for(int i=0;i<N;i++) {
 			st = new StringTokenizer(br.readLine());
 			diec[i][0] = Integer.parseInt(st.nextToken());
 			diec[i][1] = Integer.parseInt(st.nextToken());
 			diec[i][2] = Integer.parseInt(st.nextToken());
 			diec[i][4] = Integer.parseInt(st.nextToken());
 			diec[i][5] = Integer.parseInt(st.nextToken());
 			diec[i][3] = Integer.parseInt(st.nextToken());
 		}
 		for(int i=0;i<6;i++) DFS(0,diec[0][i]);
 		System.out.println(answer);
 		
	}
	
	
	private static void DFS(int diecnum, int before) {
		if(diecnum==N) {
			answer = Integer.max(answer, total);
			return;
		}
		
		for(int i=0;i<6;i++) {
			if(diec[diecnum][i] != before) continue;
			int val=-1;
			for(int j=0;j<3;j++) {
				if(i==j || j+3 == i) continue;
				val = Integer.max(val, diec[diecnum][j]);
				val = Integer.max(val, diec[diecnum][j+3]);
			}
			total +=val;
			DFS(diecnum+1,diec[diecnum][(i+3)%6]);
			total -=val;
		}
		
	}
}
