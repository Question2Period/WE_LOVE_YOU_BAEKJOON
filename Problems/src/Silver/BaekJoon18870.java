package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon18870 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		TreeSet<Integer> tree = new TreeSet<>();
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			int x= Integer.parseInt(st.nextToken());
			arr[i] = x;
			tree.add(x);
		}
		Object[] find = tree.toArray();
		for(int i = 0; i<N; i++) {
			int a= arr[i];
			sb.append(Arrays.binarySearch(find, a)).append(" ");
		}
		System.out.println(sb);			
	}
}