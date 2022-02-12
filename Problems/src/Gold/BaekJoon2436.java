package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon2436 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Max = Integer.parseInt(st.nextToken()); // 최대 공약수
		int Min = Integer.parseInt(st.nextToken()); // 최소 공배수
		int flag = 0; //서로소 검사 변수
		int num1= 0; // 수 중 작 값을 최대공약수로 나눈 변수
		int num2= 0; // 큰 값을 최대공약수로 나눈 변수
		int x = Min/Max;
		for(int i = 1; i*i<x; i++) {
			if(x%i==0) { //약수 탐색(i와 x/i가 그 약수가 된다)
				for(int j =2; j<num1; j++) { // 서로소인지 검사
					if(i%j==0&&(x/i)%j==0) {
						flag=1; //서로소가 아니라면 flag=1
						break;
					}
				}
				if(flag==0) { // 서로소 일때
				num1 = i; // 저장
				num2 = x/i;	//저장
				}
			}
			flag = 0; // flag값 초기화
		}
		if(Min!=Max) {
		System.out.printf("%d %d",num1*Max,num2*Max);
		}
		else {
			System.out.printf("%d %d",Max,Max); //두값이 같다면 그대로 출력
		}
	}

}
