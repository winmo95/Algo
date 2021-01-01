package day0101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1244 {
	static int maxNum, n;
	static int card[];
	static int first;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=testCase;tc++) {
			String[] line = br.readLine().split(" ");  //입력값을 카드 숫자, 회전 수로 전환
			char []num = line[0].toCharArray();        // 카드 정보 저장
			first = Integer.parseInt(line[0]);         // 초기 카드로 만들어진 보상
			
			n = Integer.parseInt(line[1]);           
			card = new int[line[0].length()];          // 카드 하장씩 분리
			maxNum = 0;
			for(int i=0;i<line[0].length();i++) {
				card[i] = (int)(num[i]-'0');           
			}
			
			Solve(0,0);                               // 완전탐색
			System.out.println("#"+tc+" "+maxNum);
		}
	}
	private static void Solve(int cnt,int start) {
		if(cnt == n) {
			String makeNum="";                        // 회전 후 보상값
			for(int i : card) {
				makeNum+=i;
			} 
			if(first == Integer.parseInt(makeNum) && n == 1) return;       //  교환이 1번 뿐일때 조건
			maxNum = Math.max(maxNum, Integer.parseInt(makeNum));          // 최대 보상값 
			return;
		}
		
		
		if(cnt==0) {                                                      // 교환이 1번일 때
			for(int i = start;i<card.length;i++) {
				for(int j= i+1;j<card.length;j++) {
						swap(i,j);                                      // 교환
						Solve(cnt+1,i);
						swap(i,j);					
				}
			}
		}else {			
			for(int i = start;i<card.length;i++) {                      // 회전시켜가며 모든 수를 만들어 본다
				for(int j= i+1;j<card.length;j++) {
					if(card[i] <= card[j]) {
						swap(i,j);
						Solve(cnt+1,i);
						swap(i,j);					
					}
				}
			}
		}
		
		
	}

	
	private static void swap(int i, int j) {
		int temp = card[i];
		card[i] = card[j];
		card[j] = temp;	
	}
}
