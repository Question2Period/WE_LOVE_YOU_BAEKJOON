package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1417 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N-1];
		int count = 0;
		int D = Integer.parseInt(br.readLine());
		for(int i = 0; i<N-1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if(N==1) {
			System.out.println(0);
		}
		else {
		while(true) {
			Arrays.sort(arr);
			if(D>arr[N-2]) {
				break;
			}
			if(D<=arr[N-2]) {
				D++;
				arr[N-2]--;
				count++;
			}
		}
		System.out.println(count);
	}
	}

}
