package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon12015 {
	public static ArrayList<Integer> list; 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i = 0; i<N; i++) {
			int[] temp = new int[N-1-i];
			for(int j= 0; j<N-i-1; j++)temp[j] = arr[i+1+j];
			Arrays.sort(temp);
			int x=  Arrays.binarySearch(temp, arr[i]);
			System.out.println(1);
			
			
			
		}
		System.out.println(1);
	}

}
