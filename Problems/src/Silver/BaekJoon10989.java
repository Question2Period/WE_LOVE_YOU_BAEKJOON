package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon10989 {
	public static int[] arr;
	public static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int i = 0; i<N; i++)sb.append(arr[i]).append("\n");
		System.out.println(sb);
	}

}
