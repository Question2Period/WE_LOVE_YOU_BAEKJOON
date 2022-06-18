package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon4344 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int C = Integer.parseInt(br.readLine());
		for(int i = 0; i<C; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int sum = 0;
			int[]  arr = new int[N];
			for(int j = 0; j<N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum+=arr[j];
			}
			double av = sum/N;
			int cnt = 0;
			for(int j = 0; j<N; j++) {
				if(arr[j]>av)cnt++;
			}
			sb.append(String.format("%.3f", (double)((double)cnt*100/N))+"%").append("\n");			
		}
		System.out.println(sb);
	}

}
