package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon10816 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int temp = 0;
		int[] plus = new int[10000001];
		int[] minus = new int[10000001];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			temp = Integer.parseInt(st.nextToken());
			if(temp>=0)plus[temp]++;
			else minus[Math.abs(temp)]++;
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int j =0; j<M; j++) {
			temp = Integer.parseInt(st.nextToken());
			if(temp>=0)sb.append(plus[temp]+" ");
			else sb.append(minus[Math.abs(temp)]+" ");
		}
		System.out.println(sb);
	}

}
