package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_10163 {
	static StringTokenizer st;
	static int map[][];
	static int index=1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int [102][102];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			drawMap(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			index++;
		}
		int check[] = new int [index+1];
		
		for(int i= 0; i<102 ;i++){
			for(int j= 0;j<102 ;j++){
			//	System.out.print(map[i][j]+" ");
				if(map[i][j] !=0) check[map[i][j]]++;
			}
		}
		
		for(int i=1;i<index;i++) {
			System.out.println(check[i]);
		}
	}
	private static void drawMap(int x, int y, int width, int height) {
		for(int i= x; i<x+width ;i++){
			for(int j= y;j<y+height ;j++){
				map[i][j]=index;
			}
		}
	}
}
