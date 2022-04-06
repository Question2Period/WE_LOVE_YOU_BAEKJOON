import java.io.*;
import java.util.*;
public class SWEA3307 {
	public static int[] arr;
	public static int[] length;
	public static int max;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();; 
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			max = Integer.MIN_VALUE;
			arr = new int[N+1];//입력 수열
			length = new int[N+1]; // length[i]의 의미 : i번까지 가질 수 있는 수열의 최대 길이
			for(int i = 1; i<=N; i++)arr[i] = Integer.parseInt(st.nextToken());
			for(int i = 1; i<=N; i++) {
				length[i] = 1;
				for(int j = 1; j<i; j++) {
					if(arr[i]>arr[j]) {
						length[i] = Math.max(length[i], length[j]+1);
					}
				}
				max = Math.max(max, length[i]);
			}
			sb.append("#"+t+" "+max).append("\n");
		}
		System.out.println(sb.toString());
	}

}
