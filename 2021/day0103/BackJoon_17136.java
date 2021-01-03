package day0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_17136 {
	static int map[][];
	static int use[];
	static int min;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int [10][10];
		
		use = new int [6];
		min = Integer.MAX_VALUE;
		
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		find(0,0,0);              // DFS 활용
		if(min == Integer.MAX_VALUE) System.out.println(-1);         // 덮지 못하면 -1 출력
		else System.out.println(min);
	}
	private static void find(int x,int y,int cnt) {
		 if (x >= 9 && y > 9) {                             //끝점에 도착 했을 떼 최솟값 비교
	            min = Math.min(min, cnt); 
	            return;
	        }
	 
	        if (min <= cnt) {       // 가지치키 : 최솟값보다 색종이가 더 많으면 탐색 종료
	            return;
	        }
	 
	        if (y > 9) {            // 아래 줄로 이동.
 	            find(x + 1, 0, cnt);
	            return;
	        }
	 
	        if (map[x][y] == 1) {
	            for (int i = 5; i >= 1; i--) {         // 가장 큰 종이 부터 붙혀본다
	                if (use[i] < 5 && cnaCover(x, y, i)) {     // 색종이를 5섯장 이상 사용하지 않고 종이를 덮을 수 있을 때
	                	cover(x, y, i); 			// 색종이를 붙임.
	                    use[i]++;					// 해당 크기의 종이 사용
	                    find(x, y + 1, cnt + 1);
	                    unCover(x, y, i); 			// 색종이를 다시 뗌.
	                    use[i]--;                   // 해당 크기의 종이 제거
	                }
	            }
	        } else { // 오른쪽으로 이동.
	        	find(x, y + 1, cnt);
	        }
	}
	
	private static void cover(int x,int y, int len) {
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				map[i][j]=0;
			}
		}
	}
	
	private static void unCover(int x,int y, int len) {
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				map[i][j]=1;
			}
		}
	}
	
	
	private static boolean cnaCover(int x,int y, int len) {         // 색종이를 덮을 수 있는지 확인
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				if(x<0&&x>=10&&y<0&&y>=10) {             // 범위를 벗어나면 false 반환
					return false;
				}
				if(map[i][j]==0) {                       // 0이 적힌 칸이 존재하면 false 반환
					return false;
				}
			}
		}
		return true;          // 색종이를 덮을 수 있다
	}
}
