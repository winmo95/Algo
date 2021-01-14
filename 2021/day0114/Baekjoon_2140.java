package day0114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2140 {
	static int N,total;
	static char map[][];
	static int cnt[][];
	static int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };           // 8방향 탐색
	static int dy[] = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];                     // 지뢰 지도
		cnt = new int[N][N];                      // 주변 지뢰 갯수 정보 저장
		for (int i = 0; i < N; i++) {
			char temp[] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (temp[j] != '#') {            // 오픈 한 위치
					cnt[i][j] = (int) (temp[j] - '0');    // 주변 지뢰 갯수 저장
				}
				map[i][j] = temp[j];

			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '#') {             // 만약 오픈하지 않은 곳이엿다면 오픈
					open(i, j);
				}
			}
		}
		print();

	}

	private static void open(int x, int y) {
		boolean find = true;
		for (int i = 0; i < 8; i++) {                    // 8방 탐색
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {   // 범위 내
				if(map[nx][ny]=='#') continue;              // 아직 오픈하지 않은곳
				if(map[nx][ny]==' ') continue;             // 오픈했지만 지뢰가 없을 때
				if(map[nx][ny]=='*') continue;             // 지뢰
				if(cnt[nx][ny] < 1) {                      // 주변 지뢰 갯수를 파악 -> 갯수가 0 이면 이 곳에는 지뢰를 둘 수 없다
					find = false;
					break;
				}
			}
		}

		if (find) {                                        //오픈한곳에 지뢰를 둘 수 있는지 판단
			for (int i = 0; i < 8; i++) {                  // 지뢰를 둘 수 있다
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(cnt[nx][ny] > 0) cnt[nx][ny]--;          //  cnt에 저장된 지뢰 갯수 감소
				} 
			}
			map[x][y] = '*';                                    // 지뢰 지도에 지뢰 표시
		}else {
			map[x][y] = ' ';                                    // 지뢰 지도에 지뢰 없음을 표시
		}
		
	}

	private static void print() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='*') {                         // 지뢰 갯수 파악
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
