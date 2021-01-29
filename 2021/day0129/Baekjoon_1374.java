package day0129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1374 {
	static class Course implements Comparable<Course>{
		int num,start,end;

		public Course(int num, int start, int end) {
			super();
			this.num = num;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Course o) {          // 시작 시간을 기준으로 정렬
			return this.start - o.start;
		}
		
	}
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		PriorityQueue<Course> pq = new PriorityQueue<Course>();
		
		int cnt = 0;
		int room[] = new int[N+1];
		boolean use[] = new boolean[N+1];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			pq.add(new Course(num, start, end));            // 강의 저장
		}
		
		
		while(!pq.isEmpty()) {
			Course c = pq.poll();                 
			for(int i = 1;i < N+1;i++) {
				if(room[i] <= c.start) {                   // 강의실의 강의가 끝나는 시간보다 강의 수업이 시작될때
					room[i] = c.end;       // 해당 강의장에 끝나는 시간을 저장
					use[i] = true;         // 해당 강의실을 사용했음을 표시
					break;
				}
			}
		}
		
		for(int i =1;i<N+1;i++) {
			if(use[i]) cnt++;              // 해당 강의실을 사용했는지 판단을 하고 강의실 갯수를 증가
		}
		System.out.println(cnt);
	}
}
