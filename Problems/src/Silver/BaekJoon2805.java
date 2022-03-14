package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2805 {
	public static int[] arr;
	public static int max;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int down = 0;
		int upper = arr[N-1];
		while(down<upper) {
			int middle = (down+upper)/2;
			
			long sum = 0;
			for(int i = 0;i<N; i++) {
				int each = arr[i] - middle;
				if(each>0)sum+=each;
			}
			if(sum>=M) {
				down = middle+1;
			}
			else upper = middle;
		}
		System.out.println(down-1);
	}

}
