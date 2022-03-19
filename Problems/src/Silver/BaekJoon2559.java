package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2559 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++)arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 1; i<=N-K+1; i++) {
			int sum = 0;
			for(int j = 0; j<K; j++)sum+=arr[i+j];
			if(sum>max)max = sum;
		}
		System.out.println(max);
	}

}
