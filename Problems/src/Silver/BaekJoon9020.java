package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon9020 { // 실버 1 골드바흐의 추측 -> 다시 풀어보자

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Min = Integer.MAX_VALUE; // 두 소수의 차를 담을 변수
		int number1 = 0;//출력 소수 중 작은 값
		int number2 = 0; // 출력 소수 중 큰 값
		int T = Integer.parseInt(br.readLine()); // 테스트케이스
		boolean[] arr = new boolean[10001]; // 에라토스테네스 배열
		arr[0]=arr[1]=true;
		for(int i = 2 ; i*i<10001;i++) {

			if(!arr[i]) {
				for(int j = i*i; j<10001;j+=i) {
					arr[j]=true;
				}
			}
		} //에라토스테네스의 체. 소수는 false값으로 저장된다.
		for(int i = 0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			for(int j = 2; j<n; j++) {
				if(!arr[j]&&!arr[n-j]) { //j와 n-j가 소수일 때
					if(Min>Math.abs(j-(n-j))) { // 그 차가 최소라면 실행
						Min = Math.abs(n-2*j);
						number1 = Math.min(j,n-j); // 그때의 값 저장
						number2 = Math.max(j,n-j); 
					}
				}
			}
			System.out.println(number1 + " " + number2);
			number1 =0;
			number2 = 0;
			Min = Integer.MAX_VALUE; // 저장 변수들 재 초기화
		}
		
		
	}

}
