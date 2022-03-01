package Usaco;
import java.io.*;
import java.util.*;
public class Bronze1 {
	public static int N,Max,A,result,B,flag;
	public static Set<Integer> s;
	public static int[] arr;
	public static int[] Sum;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t<T; t++) {
			Max= Integer.MIN_VALUE; // 수열 중 최대값
			N = Integer.parseInt(br.readLine());
			arr= new int[N]; // 테스트 케이스 수열
			Sum= new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ;i<N; i++) {
				A = Integer.parseInt(st.nextToken());
				arr[i] = A; 
				Max = Math.max(Max, A); //최댓값 저장
			}
			Sum[0] = arr[0]; 
			for(int i = 1; i<N; i++) { // 누적합 배열
				Sum[i] = Sum[i-1]+arr[i];
			}
			if(Sum[N-1]==0)System.out.println(0); // 누적합이 0이라면 합칠필요없으므로 0
			else {
			for(int j = Max; j<=Sum[N-1]; j++) { // 최대일때부터 누적합까지 중 나눌 수있는 수 찾기
				flag=0; // 분기를 위한 flag
				if(Sum[N-1]%j!=0)continue; //나눌 수 없다면 continue
				B= Sum[N-1]/j; 
				//수열을 모두 갖은 수로 만들었을 때 수열의 원소 개수
				for(int k = 1; k<=B; k++) {
					// j*1 ~ j*B의 순서가 누적합 배열에 없다면 수열을 j값으로 통일 불가능하다
					if(Arrays.binarySearch(Sum, j*k)<0) {//이 수가 없다면 음수
						flag=-1;
						break;
					}
				}
				if(flag==-1)continue; // 아직 만족하는 값을 못찾았으므로 계속 탐색
				break;
			}
			System.out.println(N-B); //N개의 원소를 B개로 만들려면 N-B번 연산해야한다 
			}
		}

	}
}
