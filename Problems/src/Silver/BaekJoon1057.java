package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1057 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cnt = 1;
		int flag = 0;
		while(true) {
			int t_a = a%2+a/2;
			int t_b = b%2+b/2;
			if(t_a==t_b)break;
			if(a%2==0)a/=2;
			else a=a/2+1;
			if(b%2==0)b/=2;
			else b=b/2+1;
			cnt++;
		}
		System.out.println(cnt);
	}

}
