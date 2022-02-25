package Silver;
import java.io.*;
import java.util.*;

public class BaekJoon11399 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sum =0;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int j = 0; j<N; j++) {
			sum+=(arr[j]*(N-j));
		}
		System.out.println(sum);
	}

}
