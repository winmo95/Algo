package day0117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BFS로 풀면 시간 초과
 * T 역순으로 풀기
 * StringBuilder
 * */
public class backjoon_12904 {
	static boolean made;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder T = new StringBuilder(br.readLine());     // 뒤집기, 빼기 등의 작업을 위해 StringBuilder 사용
		
		while(true) {	
			if(S.length() == T.length()) {            // 길이가 같을 때
				if(S.equals(T.toString())) {          // 만들어진다면
					System.out.println(1);           // 1 출력
				}else {
					System.out.println(0);           // 0출력
				}
				break;
			}
			
			if(T.charAt(T.length()-1)=='A') {           // T 의 마지막 문자가 A라면 마지막 문자 제거
				T.deleteCharAt(T.length()-1);
			}else {                                     // T 의 마지막 문자가 B라면 마지막 문자 제거 후 뒤집기
				T.deleteCharAt(T.length()-1);
				T.reverse();
			}
			
			
		}
	}
}
