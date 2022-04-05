package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon11722 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		int max = 0;
		for(int i = N; i>=1; i--) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] length = new int[N+1];
		for(int i =1; i<=N; i++) {
			length[i] = 1;
			for(int j = 1; j<i; j++) {
				if(arr[i]>arr[j]) {
					if(length[i]<=length[j]+1)length[i] = length[j]+1;
				}
			}
			max = Math.max(max, length[i]);
		}
		System.out.println(max);
	}

}
