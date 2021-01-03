package com.ssafy.hw.day1029;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Body{
	int x;
    int y;
    Body(int y, int x) {
        this.y = y;
        this.x = x;
    }
	
}
public class BaekJoon_3190 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int map[][],N;
    static  Map<Integer, String> dirSet;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        map = new int[N+2][N+2];
        dirSet = new HashMap<>();

        for(int i = 0; i < N+2; i++) {
            map[0][i] = map[N+1][i] = map[i][0] = map[i][N+1] = 1;
        }
      
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 2;
        }
 
     
        int order = Integer.parseInt(br.readLine());
        for(int i = 0; i < order; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            dirSet.put(x, c);
        }

        System.out.println(play());
    }
 
    private static int play() {
    	 int dir = 1;
         int time = 0;
         Deque<Body> snake = new ArrayDeque<>();
         snake.add(new Body(1,1));
         while(true) {
             time++;
             Body head = snake.peekLast();
             int nX = head.x + dx[dir];
             int nY = head.y + dy[dir];
             if(map[nY][nX]==1) {
                 break;
             }
             if(map[nY][nX] != 2) {
                 Body tail = snake.poll();
                 map[tail.y][tail.x] = 0;
             }
             map[nY][nX] = 1;
             snake.addLast(new Body(nY, nX));
             if(dirSet.containsKey(time)) {
                 dir = (dirSet.get(time).equals("D")) ? (dir+1) % 4 : (dir+3) % 4;
             }
         }
         return time;
		
	}


}