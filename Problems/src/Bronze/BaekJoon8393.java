package Bronze;
import java.io.*;
public class BaekJoon8393 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = n/2;
		if(n%2==0) {//짝
			System.out.println(cnt*(n+1));
		}
		else {
			System.out.println(cnt*(n+1)+cnt+1);
		}
	}

}
