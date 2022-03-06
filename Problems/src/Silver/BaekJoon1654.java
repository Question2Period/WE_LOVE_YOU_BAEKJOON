package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1654 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		long max = 0;
		for(int i = 0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		max++;
		long min = 0;
		long lan = 0;
		while(min<max) {
			long sum=0;
			lan= (max+min)/2;
			for(int i = 0; i<k; i++) {
				sum+=(arr[i]/lan);
			}
			if(sum<n) max = lan;		
			else  min = lan+1;
		}
		System.out.println(min-1);
	}
}
