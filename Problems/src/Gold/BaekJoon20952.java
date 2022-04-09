package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon20952 {
	public static int N,M,flag;
	private static final int answer = 1000000007;
	public static StringBuilder sb;
	public static int[] arr1,arr2;
	public static long[] original;
	public static boolean[] remain;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr1 = new int[N+1];//원본 A
		original = new long[M+1];//원본 B 누적합
		remain = new boolean[7];//원본 A의 나머지 카운팅 배열
		arr2 = new int[M+1];//B의 나머지 누적합 배열
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
			remain[arr1[i]%7]=true;
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=M; i++) {
			String str = st.nextToken();
			arr2[i] = arr2[i-1]+(Integer.parseInt(str))%7;
			original[i] = original[i-1]+Long.parseLong(str);
		}
		recur(1);
		int length = 0;
		for(int i =1; i<=N; i++) {
			if(!remain[arr1[i]%7]) continue; //제거된 값
			length++;
			long a = (arr1[i]+original[M])%answer;
			sb.append(a+" ");
		}
		if(length!=0) {
		System.out.println(length);	
		System.out.print(sb);
		}
		else {//A의 모든원소가 제거된 경우
			System.out.println(N);
			for(int i = 1; i<=N; i++) {
				System.out.print((arr1[i]%answer)+" ");
			}
		}
	}
	
	public static void recur(int a) {//a는 반복횟수
		int sum = arr2[a];
		for(int i = 0; i<7; i++) {
			if(!remain[i])continue;
			if((sum+i)%7==0) {//합이 7의 배수?			
				remain[i] = false; //이 나머지를 가진 수는 이제 제외
			}
		}
		if(a==M)return;
		recur(a+1);
		
	}
}
