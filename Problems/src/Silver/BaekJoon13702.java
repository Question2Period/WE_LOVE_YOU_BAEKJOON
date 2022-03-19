package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon13702 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long max = 0;
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = (long)Math.max(max, arr[i]);
		}
		
		long least = 0;
		if(max==0)System.out.println(0);
		else
		while(least<max) {
			int sum = 0;
			long middle = (max+least)/2;
			if(middle==0) {
				System.out.println(max);
				break;
			}
			for(int i=0; i<N; i++)sum+=(arr[i]/middle);
			if(sum>=K) {
				least = middle+1;
			}
			else if(sum<K)max = middle;
		}
		System.out.println(least-1);
	}

}
