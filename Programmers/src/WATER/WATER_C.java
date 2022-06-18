package WATER;
import java.io.*;
import java.util.*;
public class WATER_C {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[1000];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)arr[i]-=Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++)arr[i]+=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		if(arr[999]>=0)System.out.println(arr[999]);
		else System.out.println(0);
	}

}
