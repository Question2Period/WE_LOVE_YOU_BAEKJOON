package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1789 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long sum = 0;
		long cnt = 0;
		while(true) {
			
			sum+=cnt;
			if(sum>n)break;	
			cnt++;
		}
		System.out.println(cnt-1);
	}
}
