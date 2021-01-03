package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BackJoon_2564 {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N =  Integer.parseInt(br.readLine());
		List<Integer> line = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		int index =1;
		line.add(index++);
		for(int i=1;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			int size = line.size();
			line.add(size-num,index++);
		}
		
		for(int i : line) {
			System.out.print(i+" ");
		}

	}
	
}
