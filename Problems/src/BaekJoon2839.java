import java.io.*;
import java.util.*;
public class BaekJoon2839 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum=0; // 봉지의 개수
		int flag=0; // 나누어떨어지지않을때
		while(true) { 
			if(N%5==0) { // 5로 나누어 떨어진다면
				sum+=(N/5); // 봉지 개수에 5로 나눈 값을 더한다
				break; // 탈출
			}
			else { // 5로 나누어 떨어지지 않을 경우
				N-=3;
				sum++;
			}
			if(N<0) {
				flag = -1; //5와 3으로 구성되지 않는 경우 플래그 값을 -1로 바꿔준다
				System.out.println(-1); // -1 출력
				break;
			}
		}
		if(flag==0)
		System.out.println(sum);
//		int min = 5000;
//		for(int i = 0;i<=N/5;i++) {
//			for(int j = 0;j<=N/3;j++) {
//				if(5*i+3*j>N) {
//					break;
//				}
//				if(5*i+3*j==N) {
//				if(min>i+j) {
//					min = i+j;
//				}
//				}
//				else {
//					continue;
//				}
//			}
//		}
//		if(min==5000) {
//			System.out.println(-1);
//		}
//		else {
//			System.out.println(min);
//		}
	}

}
