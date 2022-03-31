package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon18310 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum1 = 0;
		int sum2 = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		if(N%2==0) {
			for(int i = 0; i<N; i++) {
				sum1+=(Math.abs(arr[i]-arr[N/2-1]));
				sum2+=(Math.abs(arr[i]-arr[N/2]));
			}
			if(sum1>sum2)System.out.println(arr[N/2]);
			else System.out.println(arr[N/2-1]);
		}
		else System.out.println(arr[N/2]);
	}

}
