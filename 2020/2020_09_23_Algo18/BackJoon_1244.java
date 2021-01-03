package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BackJoon_1244 {
	static StringTokenizer stt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stt = new StringTokenizer(br.readLine());
		int light[] = new int [n+1];
		for(int i=1;i<=n;i++) {
			light[i]  = Integer.parseInt(stt.nextToken());
		}
		int stu = Integer.parseInt(br.readLine());
		for(int i=0;i<stu;i++) {
			stt = new StringTokenizer(br.readLine());
			int person = Integer.parseInt(stt.nextToken());
			int num = Integer.parseInt(stt.nextToken());
			if(person==1) {
				for(int j = num;j<=n;j+=num) {
					if(light[j] == 0 ) light[j]=1;
					else light[j] =0;
				}
			}else if(person==2) {
				if((num==1 || num==n)||light[num-1] != light[num+1]) {
					if(light[num] == 0 ) light[num]=1;
					else light[num] =0;
				}else {
					int left = num-1;
					int right = num +1;
					if(light[num] == 0 ) light[num]=1;
					else light[num] =0;
					while(true ) {
                        if(left<=0 || right >n ) break;
						if(light[left] == light[right]) {
							if(light[left] == 1 && light[right]==1) {
								light[left] = 0;
								light[right] = 0;
							}else {
								light[left] = 1;
								light[right] = 1;
							}
							left -=1;
							right +=1;
						}else {
							break;
						}
					}
					
					
				}
			}
			
		}
		for(int i=1;i<=n;++i) {
			System.out.print(light[i]+" ");
			if(i%20 == 0) {
				System.out.println();
			}
		}
		
	} 
}
