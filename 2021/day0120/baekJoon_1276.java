package day0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekJoon_1276 {
	static class Bridge implements Comparable<Bridge>{ 
		int y,x1,x2;

		public Bridge(int y, int x1, int x2) {
			super();
			this.y = y;
			this.x1 = x1;
			this.x2 = x2;
		}

		@Override
		public int compareTo(Bridge o) {          // 높이 기준으로 정렬
			return this.y-o.y;
		}
		
	}
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
	//	PriorityQueue<Bridge> bridges = new PriorityQueue<Bridge>();
		List<Bridge> bridges = new ArrayList<Bridge>();
		for(int i = 0;i< N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			bridges.add(new Bridge(y, x1, x2-1));
		}
		
		int cnt = 0;
		Collections.sort(bridges);                 // 정렬
		for(int i =0;i<bridges.size();i++) {
			Bridge now_bridge = bridges.get(i);        // 현재 지을 다리
			
			int xLen1 = now_bridge.y;                  // 왼쪽 교각을 놓을 갯수
			int xLen2 = now_bridge.y;                  // 왼쪽 교각을 놓을 갯수
			boolean makex1 = false;
			boolean makex2 = false;
			for(int j = i-1; j> -1; j--) {            // 현재 다리 보다 낮은 높이를 가지고 있는 다리 탐색
				Bridge down = bridges.get(j);
				if(!makex1 && down.x1 <= now_bridge.x1 && now_bridge.x1 <= down.x2) {    // 현재 다리 밑(왼쪽)에 낮은 다리가 있으면
					xLen1 -= down.y;        // 현재 놓아야 하는 교갹의 갯수에서 뺀다
					makex1 =true;
				}
				
				if(!makex2 && down.x1 <= now_bridge.x2 && now_bridge.x2 <= down.x2) {    // 현재 다리 밑(오른쪽)에 낮은 다리가 있으면
					xLen2 -= down.y;        // 현재 놓아야 하는 교갹의 갯수에서 뺀다
					makex2 =true;
				}
				
				if(makex1 && makex2) {   //교각을 놓아기때문에 종료
					break;
				}
			}
			//System.out.println(xLen1+xLen2);
			cnt += (xLen1+xLen2);    // 갯수를 더한다
		}
		System.out.println(cnt);
	}
}
