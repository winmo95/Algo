package day0119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 이분 탐색
 * 
 * */
public class BaekJoon_1477 {
	static int N,M,L;
	static List<Integer> highWay;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		highWay = new ArrayList<Integer>();
		for(int i =0; i< N; i++) {
			highWay.add(Integer.parseInt(st.nextToken()));
		}
		highWay.add(0);
		highWay.add(L);
		Collections.sort(highWay);
		System.out.println(find());
	}
	private static int find() {
		int left = 0, right = L;
		while(left <= right) {
			int mid = (left+right)/2;
			int cnt = 0;
			for(int i =0;i<highWay.size()-1;i++) {
				cnt +=(highWay.get(i+1)-highWay.get(i)- 1)/mid;
				//System.out.println((highWay.get(i+1)-highWay.get(i)- 1)/mid+" "+cnt);
			}
			if(cnt > M) {
				left = mid +1;
			}else {
				right = mid-1;
			}
			//System.out.println("r : "+ right+" L : "+left);
		}
		return left;
	}
}
