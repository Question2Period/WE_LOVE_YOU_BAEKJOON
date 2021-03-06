import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BaekJoon1822 {
	/*
4 3
2 5 11 7
9 7 4
	 */

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken()); //집합 A의 원소 개수
		int b = Integer.parseInt(st.nextToken()); //집합 B의 원소 개수
		int count = a; // A의 원소 개수를 담고 있다가 이후 공통 원소를 뺴준다.
		int A[]=new int[a]; // 집합 A 배열
		int B[]=new int[b]; // 집합 B 배열
		int answer[]= new int[a+b];
		for(int k =0;k<a+b;k++) {
			answer[k]=-1;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<a;i++) { //집합 A 속 채우기
			A[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A); // 출력을 위해 오름차순 정렬
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<b;i++) {//집합 B 속 채우기		
			B[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(B);
		for(int i=0;i<b;i++) { //A와 B를 탐색하면서 같은 값 찾을시 0으로 바꿔줌.
			if(Arrays.binarySearch(A, B[i])>=0) {
				answer[Arrays.binarySearch(A, B[i])]=Arrays.binarySearch(A, B[i]);
				count--;
			}

		}
		if(count==0) { // 예외 처리 차집합 원소가 없을시 0출력
			System.out.println('0');
		}
		else {
			System.out.println(count); // 차집합 원소 개수 출력
			for(int j =0; j<a;j++) { // 0으로 바꾼 공통 원소 제외한 A의 원소 출력
				if(j!=answer[j]){
					System.out.print(A[j]+" ");
				}
			}
		}
	}
}