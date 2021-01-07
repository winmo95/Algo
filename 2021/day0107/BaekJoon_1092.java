package day0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


// 시간 초과 문제
public class BaekJoon_1092 {
	static int N,M,time;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		List<Integer> crane = new ArrayList<Integer>();
		List<Integer> box = new ArrayList<Integer>();
		time = 0;

		
		StringTokenizer st = new StringTokenizer(br.readLine());
 		for(int i=0;i<N;i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
 		Collections.sort(crane, Collections.reverseOrder());  // 크레인 제한 무게 내림차순으로 정렬
 		
 		M = Integer.parseInt(br.readLine());
 		st = new StringTokenizer(br.readLine());
 		
 		for(int j=0;j<M;j++) {
 			box.add(Integer.parseInt(st.nextToken()));
 		}
 		
 		Collections.sort(box, Collections.reverseOrder());   // 박스 무게 내림차순으로 정렬
 		
 		if(box.get(0) > crane.get(0)) {                    // 박스를 못움직이면 -1 출력 하고 종료
 			System.out.println(-1);
 			return ;
 		}
 		

 		while(!box.isEmpty()) {                            // 박스를 다 옴길때 까지 반복
 			int idx = 0;                                   // 크레인 
 			
 			for(int i = 0;i<box.size();i++) {             // 옮길 수 있는 박스 찾기 무게가 큰 순서부터
 				if(idx == N) break;                       // 모든 크레인이 박스를 옮겼으면 종료
 				if(box.get(i) <= crane.get(idx)) {        // 크레인이 박스를 옮길 수 있으면
 					box.remove(i);                        // 박스 리스트에서 제거
 					i -= 1;                               // 중요! : 박스를 하나 옮기고 리스트에서 제거했기 때문에 i 또한 1 감소 해야 제가한 박스의 다음 박스를 확인 가능한다
 					idx++;                                // 다음 크레인
 				}
 			}
 			time++;                                       // 초 증가
 		}
 		
 		System.out.println(time);                        // 초 출력
 		
 		
	}
}
