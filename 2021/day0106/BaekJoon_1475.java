package day0106;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_1475 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char []temp = br.readLine().toCharArray();
		int room[] = new int [10];
		for(char c: temp) {            // 세트 갯수 증가
			room[(int)(c-'0')]++;
		}
		int max = 0;
		int idx=0;
		for(int i=0;i<10;i++) {
			if(max < room[i]) {                // 각 세트별 1개씩 들어 있기 때문에 가장 많은 번호의 갯수 만큼 세트가 필요
				if(i == 6 || i == 9) {         // 6 9 는 뒤집어서 사용가능
					int sn = room[6] + room[9];
					if(sn%2 == 0) {            // 6 + 9 의 갯수가 짝수일때
						max = Math.max(max, sn/2);
					}else {                    // 6 + 9의 갯수가 홀수 일때 1개 더 필요
						max = Math.max(max, sn/2+1);						
					}
				}else {					
					max = room[i];             
				}
			}
		}
		
		System.out.println(max);       
	}
}
