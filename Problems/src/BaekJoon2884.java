import java.io.*;
import java.util.*;
public class BaekJoon2884 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int x = a/100+a%100/10*10+a%100%10*100;
		int y = b/100+b%100/10*10+b%100%10*100;
		System.out.println(Math.max(x, y));
	}
}
