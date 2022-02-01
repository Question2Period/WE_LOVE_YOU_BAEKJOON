package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1920 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] list = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(list);
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j<M; j++) {
			if(Arrays.binarySearch(list, Integer.parseInt(st.nextToken()))>=0) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}

}
