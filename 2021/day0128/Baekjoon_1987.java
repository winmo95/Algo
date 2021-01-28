package day0128;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

//DFS 탐색
public class Baekjoon_1987 {
	static boolean visit[];
	static int R,C;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static int maxCnt = 1;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		visit = new boolean[26];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i = 0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visit[(int)(map[0][0]-'A')] = true;           // 좌측 상단은 시작할때부터 지난간것
		Solve(0,0,1);	
		System.out.println(maxCnt);
	}
	private static void Solve(int x, int y, int cnt) {
		for(int i =0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx >=0 && nx < R && ny >= 0 && ny<C) { // 배열 안에 있는 경우만 탐색
				int cur = (int)(map[nx][ny]-'A');     // 현재 알파벳을 지나갔는지 판단
				if(!visit[cur]) {                     // 지나가지 않았으면 현재 알파벳을 지난간것으로 하고 cnt 1증가
					visit[cur] = true;
					maxCnt = Math.max(maxCnt, cnt+1);      // 최대값 
					Solve(nx,ny,cnt+1);                    // 다음 탐색
					visit[cur] = false;
				}
			}
		}
	}
}
