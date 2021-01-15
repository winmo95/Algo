package day0115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon_2589 {
	static class Point{                        // 각좌표와 시간 
		int x,y,cnt;

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	
	static int dx[] = { -1, 0, 1, 0 };                 // 사방탐색
	static int dy[] = { 0, -1, 0, 1 };             
	static int r, c,minLength = 0;
	static char map[][];                           // 지도
	static boolean visit[][];                      // 방문여부
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			char temp[] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				map[i][j] = temp[j];
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]=='L') {                               // L: 육지라면 해당 육지에서 가장 멀리 떨어진 육지를 찾는다
					visit = new boolean[r][c];                     // 매번 방뭄 체크
					solve(i,j);                                    // BFS
				}
			}
		}
		System.out.println(minLength);
	}

	private static void solve(int x, int y) {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(x, y, 0));
		visit[x][y] = true;
		int max=Integer.MIN_VALUE;                    // 최대거리 
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			for(int i=0;i<4;i++) {
				int nx = tmp.x+dx[i];
				int ny = tmp.y+dy[i];
				if(nx >=0 && nx <r && ny>=0 && ny <c && map[nx][ny] =='L' && !visit[nx][ny] ) {                   // 좌표를 벗어나지 않고 육지 일때
					visit[nx][ny] = true;
					q.add(new Point(nx, ny, tmp.cnt+1));
					max = Math.max(max, tmp.cnt+1);                                                                // 최대 거리를 구한다
				}
			}
		}
		minLength = Math.max(max, minLength);                                                                       // 각 섬에서 최대 거리 즉 답
	}
}
