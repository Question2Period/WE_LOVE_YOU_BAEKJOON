package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon3273 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int count = 0;
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int x = Integer.parseInt(br.readLine());
		int a = 0;
		int b = n-1;
		while(a!=b) {
			if(arr[a]+arr[b]>x) {
				b--;
			}
			else if(arr[a]+arr[b]<x) {
				a++;
			}
			else {
				count++;
				a++;
			}
		}
		System.out.println(count);
	}

}
