package com.ssafy.hw.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
class Point{
	int x,y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class SwAcademy_Processor_1767 {
	static int N,answer,count,max;
	static int map[][];

	static int dx[] = {-1,0,1,0};  //  상,좌,하,우
	static int dy[] = {0,-1,0,1};
	static StringTokenizer st;
	static List<Point> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());
		
		for(int tc =1;tc<= TestCase;tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			
			answer = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			list = new ArrayList<Point>();
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						list.add(new Point(i, j));
						
					}
				}
			}

			Solve(0,0,0);
			System.out.println("#"+tc+" "+answer);
//			for(int i=0;i<N;i++) {
//				for(int j=0;j<N;j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
		}
	}

	private static void Solve(int core,int lineCount, int Corecnt) {
		if(core == list.size()) {
			if(Corecnt > max) {
				answer = lineCount; 
				max = Corecnt;
			}else if(Corecnt == max) {		
				answer = Math.min(+answer, lineCount);
			}

			return;
		}
		int x = list.get(core).x;
		int y = list.get(core).y;
	
		for(int i=0;i<4;i++) {
			int nx = x;
			int ny = y;
			int count = 0;
		//	System.out.println(isConnect(nx,ny,i)+" "+i);
			if( (count = isConnect(nx,ny,i)) !=-1   ) {
				makeLine(nx,ny,i,1,count);
				Solve(core+1,lineCount+count,Corecnt+1);
				makeLine(nx,ny,i,0,count);
			}
		}
		Solve(core+1,lineCount,Corecnt);
		
	}

	private static void makeLine(int nx, int ny, int dir, int value, int count) {
		// TODO Auto-generated method stub
	
		for(int i=0;i<count;i++) {
			nx = nx+dx[dir];
			ny = ny+dy[dir];
			map[nx][ny] = value;
		}
	}

	private static int isConnect(int nx, int ny, int dir) {
		int count =0;
		
		while(true) {
			nx += dx[dir];
			ny += dy[dir];
			if(nx >= N || nx <0 || ny >= N || ny <0) {
				break;
			}
			if(map[nx][ny] == 1) {
				count=-1;
				break;
			}
			count++;
		}
		return count;
	}

}
