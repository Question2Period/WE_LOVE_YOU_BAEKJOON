package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2960 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		int erase = 0;
		boolean[] arr = new boolean[N+1]; // 에라토스테네스 배열
		arr[0]=arr[1]=true;
		for(int i = 2 ; i<N+1;i++) {

			if(!arr[i]) {
				count++;
				if(count == K) {
					erase = i;
					break;
				}
				for(int j = 2*i; j<N+1;j+=i) {
					if(!arr[j]) {
					arr[j]=true;
					count++;
					}
					if(count == K) {
						erase = j;
						break;
					}
				}
				if(erase!=0) {
					break;
				}
			}
		} //에라토스테네스의 체. 소수는 false값으로 저장된다.
		if(erase!=0) {
			System.out.println(erase);
		}
		
	}
}
