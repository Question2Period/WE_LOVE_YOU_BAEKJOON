package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon11054 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1]; //입력 수열
		int[] reverse = new int[N+1]; //뒤집기
		int[] count = new int[N+1]; //길이 수열
		int[] count_reverse = new int[N+1]; //길이 수열
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			reverse[N+1-i] = arr[i];
		}
		for(int i =1; i<=N; i++) {
			count[i] = 1;
			for(int j= 1; j<i; j++) {
				if(arr[i]>arr[j]) {
					if(count[i]<=count[j])count[i] = count[j]+1;
				}
			}
		}
		for(int i =1; i<=N; i++) {
			count_reverse[i] = 1;
			for(int j= 1; j<i; j++) {
				if(reverse[i]>reverse[j]) {
					if(count_reverse[i]<=count_reverse[j])count_reverse[i] = count_reverse[j]+1;
				}
			}
		}
		for(int i = 1; i<=N; i++) {
			max = Math.max(count[i]+count_reverse[N-i+1],max);
		}
		System.out.println(max-1);	
	}

}
