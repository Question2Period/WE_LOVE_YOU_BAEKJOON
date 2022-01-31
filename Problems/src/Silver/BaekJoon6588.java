package Silver;
import java.io.*;
public class BaekJoon6588 { // 실버 1 골드바흐의 추측 -> 다시 풀어보자

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int MAX = Integer.MIN_VALUE; // 두 소수의 차를 담을 변수
		int number1 = 0;//출력 소수 중 작은 값
		int number2 = 0; // 출력 소수 중 큰 값
		boolean[] arr = new boolean[1000001]; // 에라토스테네스 배열
		arr[0]=arr[1]=true;
		for(int i = 2 ; i*i<1000001;i++) {

			if(!arr[i]) {
				for(int j = i*i; j<1000001;j+=i) {
					arr[j]=true;
				}
			}
		} //에라토스테네스의 체. 소수는 false값으로 저장된다.
		String str;
		while(!(str=br.readLine()).equals("0")) { //0들어올시 종료
			int n = Integer.parseInt(str);
			for(int j = 3; j<n; j++) {
				if(!arr[j]&&!arr[n-j]) { //j와 n-j가 소수일 때
					if(MAX<n-2*j) { //최대일때
						MAX = n-2*j;
						number1 = j; // 그때의 값 저장
						number2 = n-j; 
						break;
					}
				}
			}
			if(MAX!=Integer.MIN_VALUE&&number1!=2) { // 소수 중 유일한 짝수 2 제외
				bw.write(n+" = "+number1+" + "+number2+"\n");
			}
			else{
				bw.write("Goldbach's conjecture is wrong.\n"); // 예외
			}
			number1 =0;
			number2 = 0;
			MAX = Integer.MIN_VALUE; // 저장 변수들 재 초기화
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}

