package day0113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정렬 사용하기
public class swea_1208{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for(int tc = 1;tc<=10;tc++) {
			int dump = Integer.parseInt(br.readLine());
			String []temp = br.readLine().split(" ");
			int map[] = new int[temp.length];
			
			for(int i = 0;i<temp.length;i++) {
				map[i]= Integer.parseInt(temp[i]);
			}
			for(int i=0;i<dump;i++) {
				Arrays.sort(map);                 // 오름차순으로 정렬
				map[temp.length-1]--;             // 최대 높이에서 높이 1빼서
				map[0]++;                         // 최솟 높이 채우기
			}
			
			Arrays.sort(map);
			System.out.println("#"+tc+" "+(map[temp.length-1]-map[0]));        // 최대 최소 높이 차이 계산
		}
		
	}
}
