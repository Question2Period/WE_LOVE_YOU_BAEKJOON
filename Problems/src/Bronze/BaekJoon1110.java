package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon1110 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int next = 0;
		int first = 0;
		int second = 0;
		int cur = n;
		while(true) {
			first = cur/10;
			second = cur%10;
			cur = second*10+(first+second)%10;
			if(cur==n)break;
			cnt++;
		}
		System.out.println(cnt+1);
	}

}
