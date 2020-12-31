package day1231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_9280 {
	static int n, m, R_i[], W_i[];
	static boolean use[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			R_i = new int[n];
			use = new boolean[n];   // 해당 주차 위치를 사용하는지 판별

			W_i = new int[m+1];

			Queue<Integer> order = new LinkedList<Integer>();  // 모든 자동차의 주차 순서 및 빠져나가는 순서 저장
			Queue<Integer> temp = new LinkedList<Integer>();   // 대기할 차량
			Map<Integer, Integer> porder = new HashMap<Integer, Integer>();  // 주차 정보 저장
			int money = 0;
			for (int i = 0; i < n; i++) {
				R_i[i] = Integer.parseInt(br.readLine());      // 주차비
			}

			for (int i = 1; i <= m; i++) {
				W_i[i] = Integer.parseInt(br.readLine());      // 자동차 무게
			}

			for (int i = 0; i < 2 * m; i++) {                  // 모든 차가 들어오고 나가기 때문에 2*m
				order.add(Integer.parseInt(br.readLine()));
			}
			
			
			int minIndex = 0;
			while (!order.isEmpty()) {
				int car = order.poll();

				// 차를 주차할 때
				if (car > 0) {
					// 주차장에 빈공간이 없을 때
					if (porder.size() == n) {
						temp.add(car);
					} else {
						// 주자장에 공간이 있을 떼
						minIndex = 0;     
						while (true) { 
							if (!use[minIndex]) {  					// 해당 주차 공간에 차가 있는 지 판단
								porder.put(car, minIndex);  		// 차가 없으면 해당 공간에 주차
								use[minIndex] = true;      	 		// 해당 공간 사용 불가 표시
								break;
							}
							minIndex++;  							// 주차 공간찾기 
						}
					}
				} else { 											// 차를 뺄때
					int key = car * -1;           
					int site = porder.get(key);  					// 주차한 위치
					porder.remove(key); 							// 헤당 위치의 자동차 제거
					use[site] = false;  							// 해당 위치를 사용할 수 있는 공간으로 표시
					money += (R_i[site] *W_i[key]); 				// 주차비 계산
					// 대기 하는 차량이 있을 때
					if (!temp.isEmpty()) {      
						minIndex = 0;       						// 최소 위치 찾기
						while (true) {
							if (!use[minIndex]) {
								porder.put(temp.poll(), minIndex);  // 대기하는 차량 주차
								use[minIndex] = true;
								break;
							}
							minIndex++;
						}
					}
				}

			}

			System.out.println("#" + tc + " " + money);
		}
	}
}
