package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_13300 {
		static StringTokenizer st;
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int map[][] = new int[2][7];
			
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
			}
			
			int sum=0;
			for(int i=1;i<7;i++) {
//				System.out.println((i)+" 학년");
//				System.out.println("여 : " +map[0][i]+" 남 : "+map[1][i]);
				if(map[0][i] !=0) {
					sum += map[0][i]/K;
					if(map[0][i]%K !=0) sum+=1;
				}
				if(map[1][i] !=0) {
					sum += map[1][i]/K;
					if(map[1][i]%K !=0) sum+=1;
				}
			}
			System.out.println(sum);
		}
}
