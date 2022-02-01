package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1978 { // 실버 1 골드바흐의 추측 -> 다시 풀어보자

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;

		boolean[] arr = new boolean[1001]; // 에라토스테네스 배열
		arr[0]=arr[1]=true;
		for(int i = 2 ; i*i<1001;i++) {

			if(!arr[i]) {
				for(int j = i*i; j<1001;j+=i) {
					arr[j]=true;
				}
			}
		} //에라토스테네스의 체. 소수는 false값으로 저장된다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0;i<N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(!arr[x]) {
				count++;
			}
		}
		System.out.println(count);
}
}