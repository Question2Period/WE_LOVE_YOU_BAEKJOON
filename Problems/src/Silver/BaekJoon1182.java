package Silver;
import java.io.*;
import java.util.*;

public class BaekJoon1182 {
	public static int N;
	public static int S;
	public static int count=0;
	public static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Group(0,0);
		if(S == 0)System.out.println(count-1);
		else 
			System.out.println(count);
	}
	public static void Group(int index, int sum) {
		if(index==N) {
			if(sum==S) {
			count++;
			}
			return;
		}
				
		Group(index+1,sum+arr[index]);
		Group(index+1, sum);
		

	}

//	public static void Group(int index,int cnt, int sum) {
//		if(cnt!=0) {
//			if(sum==S) {
//			count++;
//			return;
//			}
//
//		}
//		if(index ==N) return;
//				
//		Group(index+1,cnt+1,sum+arr[index]);
//		Group(index+1,cnt+1, sum);
//		
//
//	}
}
