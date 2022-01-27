import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class BaekJoon12866 {
	static final long nose =1000000007;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str=br.readLine();
		long[] arr = new long[4];
		for(int i = 0;i<L;i++) {
			if(str.charAt(i)=='A') {
				arr[0]++;
			}
			else if(str.charAt(i)=='T') {
				arr[1]++;
			}
			else if(str.charAt(i)=='G') {
				arr[2]++;
			}
			else if(str.charAt(i)=='C'){
				arr[3]++;
			}
		}

		
		long a=arr[0]*arr[1]%nose;
		long b=arr[2]*arr[3]%nose;
		long c = a*b%nose;
		System.out.println(c);
	}

}
