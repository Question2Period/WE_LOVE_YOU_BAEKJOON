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
		arr = new int[N];
		st = new StringTokenizer(br.readLine(),",");
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int j = 0; j<K; j++) recur(arr);
		for(int j = 0; j<arr.length-1; j++) System.out.print(arr[j]+",");
		System.out.print(arr[arr.length-1]);
	}
	public static void recur(int[] x) {
		copy = new int[x.length-1];
		for(int i =0; i<x.length-1; i++) {
			copy[i] = x[i+1]-x[i];
		}
		arr = copy;
	}

}
