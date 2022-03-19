package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon10815 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N =Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i<N; i++)arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i= 0; i<M; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(Arrays.binarySearch(arr, x)>=0)System.out.print(1+" ");
			else System.out.print(0+" ");
		}
	}

}
