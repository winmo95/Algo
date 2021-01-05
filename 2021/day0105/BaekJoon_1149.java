package day0105;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1149 {                                            // 동적할당
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] town = new int [N+1][4];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(i==1) {                                                   // 첫번째 집을 색칠하는 비용 저장
				town[i][1] = Integer.parseInt(st.nextToken());
				town[i][2] = Integer.parseInt(st.nextToken());
				town[i][3] = Integer.parseInt(st.nextToken());
			}else {                                                      // 두번째 칩 칠하기
				for(int j=1;j<=3;j++) {
					int min = Integer.MAX_VALUE;
					int num = Integer.parseInt(st.nextToken());         // 모든 샊깔을 사용함
					for(int k=1;k<=3;k++) {
						if(j==k) continue;                              // 이전집과 같은 색깔은 사용하면 안됨
						int temp = num+town[i-1][k];                    // 이전집과 현재 집을 칠하는 비용
						min = Math.min(min, temp);                      // 최솟값 구하기
					}
					town[i][j] = min;                                   // 칠하는 비용이 가장 적은 값을 저장
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
        for(int i=1;i<=3;i++) {
            answer = Integer.min(answer, town[N][i]);                    // 마지막 집을 칠하는 비용 중 최솟값 찾기 
        }
        System.out.println(answer);
	}
}
