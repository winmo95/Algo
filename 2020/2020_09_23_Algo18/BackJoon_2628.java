package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BackJoon_2628 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		
		
		
		List<Integer> row = new ArrayList<Integer>();
		List<Integer> col = new ArrayList<Integer>();
		
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			if(dir==0) {
				row.add(pos);
			}
			else {
				col.add(pos);
			}
		}
		
		row.add(0);
		row.add(C);
		col.add(0);
		col.add(R);
		Collections.sort(row);
		Collections.sort(col);
	
		int mh=0,mw=0;
		for(int i=1;i<row.size();i++) {
			mh = Math.max(Math.abs(row.get(i-1)-row.get(i)),mh);
		}

		for(int i=1;i<col.size();i++) {
			mw = Math.max(Math.abs(col.get(i-1)-col.get(i)),mw);
		}
//		for(int i=0;i<C;i++) {
//			for(int j=0;j<R;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		System.out.println(mw*mh);
	}
}
