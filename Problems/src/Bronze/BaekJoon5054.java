package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon5054 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			String store = br.readLine();
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(store);
			for(int x = 0; x<n;x++) {
				arr[x]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			System.out.println(2*(arr[n-1]-arr[0]));
		}
	}
}

