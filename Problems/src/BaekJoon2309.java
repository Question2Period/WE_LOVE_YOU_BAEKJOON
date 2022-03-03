import java.util.*;
import java.io.*;

public class BaekJoon2309 {
	public static int[] arr=new int[10]; // 패딩하여 10칸으로 선언
	public static int sum;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=9; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i]; // 가짜 포함 9명의 키의 합
		}
		sum-=100; // 가짜 난쟁이 두 명의 합
		Arrays.sort(arr);//오름차순 정렬
		int p1 = 1; //가장 키 작은 난쟁이를 가리키는 포인터
		int p2 = 9; // 가장 키가 큰 난쟁이를 가리키는 포인터
		while(p1!=p2) { // 두 포인터가 같은 값을 가리킨다는 건, 배열을 전부 탐색했다는 것
			if(arr[p1]+arr[p2]<sum)p1++;//두 명의 합이 sum보다 작으면 최소값의 인덱스를 올린다
			else if(arr[p1]+arr[p2]>sum)p2--; //두 명의 합이 sum보다 크면 최대값의 인덱스를 낮춘다.	
			else break; // 두명의 합이 sum과 같다면 찾았다는 것이므로 탐색 종료
		}
		for(int i = 1; i<=9; i++) { // 출력
			if(i==p1||i==p2)continue; // 가짜들의 인덱스 제외 모두 출력한다.
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}
} 
