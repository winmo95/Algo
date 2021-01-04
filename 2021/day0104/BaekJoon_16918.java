package day0104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
class Point{             // 좌표 저장
	int x,y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class BaekJoon_16918 {
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static char [][] map;              // 격자판
	static int R,C,N;
	static Queue<Point> bomb;          // 3초전 폭탄을 저장할 큐
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		bomb = new LinkedList<Point>();
		for(int i=0;i <R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		
		if(N!=1) {	    // N = 1일 떼 격자판에서는 아무런 일이 발생하지 않는다
			install();  // 초기 폭탄 설치
			Bomb();     // 다음 단계
 		}
		print();        // 격자판 출력
	}
	
	
	private static void Bomb() {
		// TODO Auto-generated method stub
		
		int time=2;            // 모든폭탄을 다 설치 한 후 시작하기 때문에 2초
		
		while(true) {  // N초 후 끝
			if(time>=N) break;            // N초가 되면 반복 종료
			int size = bomb.size();       // 3초전에 설치된 폭탄 좌표
			for(int j=0;j<size;j++) {    //3초전 폭탄 폭발
				Point point = bomb.poll();     // 3초전 폭탄을 폭발
				map[point.x][point.y] = '.';     
				for(int k=0;k<4;k++) {         
					int nx = point.x+dx[k];
					int ny = point.y+dy[k];
				//	System.out.println(nx+" "+ny);
					if(nx>=0 && nx<R && ny>=0 && ny<C) {  // 격자판을 벗어나지 않는 좌표
						map[nx][ny] = '.';                // 인접 폭탄 폭발
					}
				}
			}
			time++;               // 초 증가
		//	print();
			if(time>=N) break;     // N초가 되면 반복 종료
			
			// 남은 폭탄 저장
			install();             // 폭탄이 썰치 되지 않은 위치에 폭탄 설치
			time++;
		}
		
	}
	
	private static void install() { 
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] == 'O') {            // 폭탄이 설치되어 있으면 큐에 저장
					bomb.add(new Point(i,j));
				}else{
					map[i][j] = 'O';              // 폭탄이 설치되어 있지 않으면 폭탄 설치
				}
			}
		}
	}
	 
	private static void print() {                  // 출력
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
