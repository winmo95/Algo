package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_14696 {
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	
		int A[] = new int [5]; 
		int B[] = new int [5]; 
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for(int j=0;j<count;j++) {
				
				A[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			count = Integer.parseInt(st.nextToken());
			for(int j=0;j<count;j++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			
			System.out.println(Compare(A,B));
			Arrays.fill(A, 0);
			Arrays.fill(B, 0);
		}
	}
	
	private static char Compare(int[] A, int[] B) {
		if(A[4]==B[4]) {
			if(A[3]==B[3]) {
				if(A[2]==B[2]) {
					if(A[1]==B[1]) {
						return 'D';
					}else {
						if(A[1] > B[1]) return 'A';
						else return 'B';
					}
				}else {
					if(A[2] > B[2]) return 'A';
					else if(A[2] < B[2]) return 'B';
					else return 'D';
				}
			}else {
				if(A[3] > B[3]) return 'A';
				else if(A[3] < B[3]) return 'B';
				else return 'D';
			}
		}else {
			if(A[4] > B[4]) return 'A';
			else if(A[4] < B[4]) return 'B';
			else return 'D';
		}
	}
}
