package day0114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 백준 1916번과 비슷한 문제
 * 차이점은 출력 뿐
 * 
 * */
public class BaekJoon_1753 {
	static class GRAP implements Comparable<GRAP>{
		int to,wei;

		public GRAP(int to, int wei) {
			super();
			this.to = to;
			this.wei = wei;
		}

		@Override
		public int compareTo(GRAP o) {
			// TODO Auto-generated method stub
			return this.wei - o.wei;
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<GRAP>> mat = new ArrayList<ArrayList<GRAP>>();
		
		for(int i =0;i<=V;i++) {
			mat.add(new ArrayList<GRAP>());
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			mat.get(u).add(new GRAP(v, w));
		}
		
		int distance[] = new int [V+1];
		boolean visit[] = new boolean [V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<GRAP> pq = new PriorityQueue<>();
		pq.add(new GRAP(start, 0));
		distance[start] = 0;
		
		while (!pq.isEmpty()) {
			GRAP currentNode = pq.poll();
			int current = currentNode.to;
			
			if(!visit[current]) {
				visit[current] = true;
				for(GRAP grap : mat.get(current)) {
					if(!visit[grap.to] && distance[grap.to] > distance[current] + grap.wei) {
						distance[grap.to] = distance[current] + grap.wei;
						pq.add(new GRAP(grap.to, distance[grap.to]));
					}
				}
			}
		}
		
		for(int i=1;i<=V;i++) {			
			if(distance[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(distance[i]);
		}
		
	}
}
