package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon1551 {
	public static int N,K;
	public static int[] arr;
	public static int[] copy;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N]; //패딩 따로 안함
		st = new StringTokenizer(br.readLine(),","); //쉼표로 구분
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int j = 0; j<K; j++) recur(arr); //반복
		for(int j = 0; j<arr.length-1; j++) System.out.print(arr[j]+",");
		System.out.print(arr[arr.length-1]); //마지막 출력때는 쉼표가 없으므로 따로 찢어줌
	}
	public static void recur(int[] x) {
		copy = new int[x.length-1]; //원래 수열보다 길이 1 짧은 배열 선언
		for(int i =0; i<x.length-1; i++) {
			copy[i] = x[i+1]-x[i]; // 빼기 연산 수행
		}
		arr = copy; // arr의 주소를 copy로 바꿔줌.
	}

}
