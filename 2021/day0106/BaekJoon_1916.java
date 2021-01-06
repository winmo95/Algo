package day0106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라 알고리즘
public class BaekJoon_1916 {

	static class Vertex implements Comparable<Vertex> { // 마을 위치, 비용
		int no, Distance;

		public Vertex(int no, int Distance) {
			super();
			this.no = no;
			this.Distance = Distance;
		}

		@Override
		public int compareTo(Vertex o) { // priority que를 사용하기 위해
			// TODO Auto-generated method stub
			return this.Distance - o.Distance; // Distance가 작은 비용이 우선적으로 처리
		}
	}

	static ArrayList<ArrayList<Vertex>> bus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		final int INFINITY = Integer.MAX_VALUE;
		bus = new ArrayList<>(); // 운행 정보

		for (int i = 0; i <= N; i++) {
			bus.add(new ArrayList<Vertex>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int no = Integer.parseInt(st.nextToken());
			int Distance = Integer.parseInt(st.nextToken());

			bus.get(start).add(new Vertex(no, Distance));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// 다익스트라 알고리즘 pq를 사용하여
		PriorityQueue<Vertex> pq = new PriorityQueue<>();        
		boolean visit[] = new boolean[N + 1];
		int distanct[] = new int[N + 1];
		Arrays.fill(distanct, INFINITY);
		pq.offer(new Vertex(start, 0));
		distanct[start] = 0;

		while (!pq.isEmpty()) {
			// 1단계 : 방문하지 않은 정점들 중 출발지에서 자신까지 오는 비용이 최단인 정점을 고려할 경유지로 선택
			Vertex currentNode = pq.poll();
			int current = currentNode.no;

			if (!visit[current]) {
				//2단계 : 선택된 current 정점을 경유지로 해서 아직 방문하지 않은 다른 정점으로의 최단거리 비용 계산하여 유리하면 update
				visit[current] = true;
				for (Vertex vertex : bus.get(current)) {
					// min ==> distance[current]
					if (!visit[vertex.no] && distanct[vertex.no] > distanct[current] + vertex.Distance) {
						distanct[vertex.no] = distanct[current] + vertex.Distance;
						pq.add(new Vertex(vertex.no, distanct[vertex.no]));
					}
				}
			}
		}

		System.out.println(distanct[end]);  // 최솟값 출력

	}
}
