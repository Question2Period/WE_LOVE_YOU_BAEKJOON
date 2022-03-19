package Regular;
import java.io.*;
import java.util.*;
public class A_20220319 {
	public static long a,b,temp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long L = Long.parseLong(st.nextToken());
		long R = Long.parseLong(st.nextToken());
		while(true) {
			a = L;
			b = R;
		while((long)a%b>0) {
			a=(long)a%b;
			temp = a;
			a = b;
			b = temp;
		}
		if(b==1)break;
		R--;
		}
		System.out.println((long)R-L);
	}
}