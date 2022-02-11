package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1654 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length = 0;
		int max = 0;
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		for(int i = 0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		for(int i = arr[k-1]/n; i<arr[0];i++) {
			for(int j = 0; j<k; j++) {
				length+=(arr[j]/i);
			}
			if(length>=n) {
				if(i>max) {
					max=i;
				}
			}
			else {
				break;
			}
			length=0;
		}
		System.out.println(max);
	}

}
