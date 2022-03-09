package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1676 {
	public static int sum2,a,b,sum5;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		a=2;
		b=5;
		while(a<=N) {
			sum2+=N/a;
			a*=2;
		}
		while(b<=N) {
			sum5+=N/b;
			b*=5;
		}
		System.out.println(Math.min(sum2, sum5));
	}

}
