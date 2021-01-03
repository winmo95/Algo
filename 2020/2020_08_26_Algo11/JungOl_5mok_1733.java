package com.ssafy.hw.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Point{
	int x,y,dir;

	public Point(int x, int y,int dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

public class JungOl_5mok_1733 {
	static int map[][];
    static int visit[][];
    static final int SIZE = 20;
    static StringTokenizer st;
    static Stack<Point> s = new Stack<Point>();
    static boolean GameOver = false;  
    static int WinColar;
    static int dx[] = {-1,1,1,0,-1}; //상,하,우하,우,우상
    static int dy[] = {0,0,1,1,1};
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[SIZE+1][SIZE+1];
        visit = new int[SIZE+1][SIZE+1];
        for(int i=1;i<SIZE;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<SIZE;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        for(int i=1;i<=SIZE;i++) {
            if(GameOver) break;
            for(int j=1;j<=SIZE;j++) {
                if(GameOver) break;
                if(map[i][j]== 1 || map[i][j]== 2) {
                    DFS(1,i,j,map[i][j],7);
                }
            }
        }
         
        if(s.isEmpty()) System.out.println(0);
        else {
            Point point = new Point(0, 0, 0);
            int WinX =0, WinY=0;
            if(!s.isEmpty()) {
                point = s.pop();
                WinX = point.x;
                WinY = point.y;
            }
             
            System.out.println(WinColar);
            System.out.println(WinX+" "+WinY);
        }
        return;
    }
   
     
       
    private static void DFS(int cnt,int x, int y, int num,int dir) {
        if(GameOver) return;
        if(cnt==5) {
            int x1 = x+dx[dir];
            int y1 = y+dy[dir];
              
            if(isOut(x1, y1)) {
                boolean flag = true;
                if(map[x1][y1]==num) return;
                 
                switch (dir) {
                case 0:
                    if(isOut(x+5, y)) {                     
                        if(map[x+5][y]==map[x][y]) flag = false;  //상
                    }
                    break;
                case 1:
                    if(isOut(x-5, y)) {                     
                        if(map[x-5][y]==map[x][y]) flag = false;  //하
                    }
                    break;
                case 2:
                    if(isOut(x-5, y-5)) {                       
                        if(map[x-5][y-5]==map[x][y]) flag = false;  //좌하
                    }
                    break;
                case 3:
                    if(isOut(x, y-5)) {                     
                        if(map[x][y-5]==map[x][y]) flag = false;  //우
                    }
                    break;
                case 4:
                    if(isOut(x+5, y-5)) {                       
                        if(map[x+5][y-5]==map[x][y]) flag = false;  //우상
                    }
                    break;
                }
                if(flag) {
                    s.add(new Point(x, y, dir));
                    GameOver = true;
                    WinColar = num;
                }
            }   
            return;
        }
         
        for(int i=0;i<dx.length;i++) {
            if(dir==7 || dir==i) {
                int xx = x+dx[i];
                int yy = y+dy[i];
                if(isOut(xx, yy)) {
                    if(num==map[xx][yy]) {
                        DFS(cnt+1,xx,yy,num,i);
                        if(GameOver) s.add(new Point(x, y, dir));
                    }
                }
            }
        }
    }
 
    private static boolean isOut(int x,int y) {
        return (x>0&&x<=SIZE && y>0 && y<=SIZE);
    }
}