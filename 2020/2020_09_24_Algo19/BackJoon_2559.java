package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_2559 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int map[] = new int [l];
		
		st = new StringTokenizer(br.readLine());

		map[0] = Integer.parseInt(st.nextToken());
		for(int i=1;i<l;i++) {
			map[i] =map[i-1] + Integer.parseInt(st.nextToken());
		}
		int max = map[k-1];
		for(int i=k;i<l;i++) {
			max = Integer.max(max, map[i]-map[i-k]);
		}
		System.out.println(max);
	}
}
