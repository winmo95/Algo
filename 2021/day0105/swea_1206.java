package day0105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1206 {
	static int map[][], len;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			len = Integer.parseInt(br.readLine());
			map = new int[len + 1][255];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < len; i++) {                               //빌딩 표시
				int num = Integer.parseInt(st.nextToken());
				for (int j = 0; j < num; j++) {
					map[i][j] = 1;
				}
			}

			int count = 0;
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < 255; j++) {
					if (map[i][j] == 1) {                               // 해당 층 기준으로 2 타일 내에 빌딩이 있는지 판단
						boolean light = false;
						if (i - 1 >= 0) {
							if (map[i - 1][j] == 1)
								light = true;
						}
						if (i - 2 >= 0) {
							if (map[i - 2][j] == 1)
								light = true;

						}
						if (i + 1 < len) {
							if (map[i + 1][j] == 1)
								light = true;

						}
						if (i + 2 < len) {
							if (map[i + 2][j] == 1)
								light = true;
						}
						if (!light) {                                 // 빌딩이 없으면 count 증가
							count++;
						}

					}

				}
			}
			System.out.println("#"+tc+" "+count);
		}
	}
}
