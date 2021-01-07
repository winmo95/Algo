package day0107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_1074 {
static int x,y,N,count=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		System.out.println(Search(x,y,N));
	}
	
	private static int Search(int xx, int yy, int size) {
		if(size == 0) {
			return 0;
		}else {
			int len = (int)Math.pow(2, size-1);
			if(xx < len && yy < len) {                                     // 1사분면
				return Search(xx, yy, size-1);
			}else if(xx < len && yy >= len) {
				return (len*len) + Search(xx, yy-len, size-1);              // 2사분면
			}else if(xx >= len && yy < len) {
				return (len*len)*2 + Search(xx-len, yy, size-1);             // 3사분면
			}else { 
				return (len*len)*3 + Search(xx-len, yy-len, size-1);         // 4사분면
			}
		}
		
	}
}
