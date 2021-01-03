package com.ssafy.hw.day1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int direction;
	int y;
	int x;

	Point(int direction, int distance, int c, int r) {
		this.direction = direction;

		if (direction == 1) {
			this.y = 0;
			this.x = distance;
		} else if (direction == 2) {
			this.y = c;
			this.x = distance;
		} else if (direction == 3) {
			this.y = distance;
			this.x = 0;
		} else {
			this.y = distance;
			this.x = r;
		}
	}
}

public class BaekJoon_2564 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<Point>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			Point p = new Point(dir, dis, c, r);
			list.add(p);
		}
		st = new StringTokenizer(br.readLine());
		
		int d = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		Point dong = new Point(d, v, c, r);
		int temp = 0;
		int ans = 0;

		if (d == 1) {
			temp = 2;
		} else if (d == 2) {
			temp = 1;
		} else if (d == 3) {
			temp = 4;
		} else {
			temp = 3;
		}

		for (Point p : list) {
			if (p.direction == temp) {
				if (p.direction == 1 || p.direction == 2) {
					ans += Math.min(dong.y + p.y + dong.x + p.x, dong.y + p.y + r - dong.x + r - p.x);
				} else {
					ans += Math.min(c - dong.y + c - p.y + dong.x + p.x, dong.y + p.y + dong.x + p.x);
				}
			} else {
				ans += Math.abs(dong.y - p.y) + Math.abs(dong.x - p.x);
			}
		}
		System.out.println(ans);
	}
	
}

