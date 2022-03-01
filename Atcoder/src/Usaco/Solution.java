//package Usaco;
import java.io.*;
import java.util.*;
public class Solution {
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
			Max= Integer.MIN_VALUE;
			N = Integer.parseInt(br.readLine());
			arr= new int[N];
			Sum= new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ;i<N; i++) {
				A = Integer.parseInt(st.nextToken());
				arr[i] = A;
				Max = Math.max(Max, A);
			}
			Sum[0] = arr[0];
			for(int i = 1; i<N; i++) {
				Sum[i] = Sum[i-1]+arr[i];
			}
			if(Sum[N-1]==0)System.out.println(0);
			else {
			for(int j = Max; j<=Sum[N-1]; j++) {
				flag=0;
				if(Sum[N-1]%j!=0)continue;
				B= Sum[N-1]/j;
				for(int k = 1; k<=B; k++) {
					if(Arrays.binarySearch(Sum, j*k)<0) {
						flag=-1;
						break;
					}
				}
				if(flag==-1)continue;
				break;
			}
			System.out.println(N-B);
			}
		}

	}
}
