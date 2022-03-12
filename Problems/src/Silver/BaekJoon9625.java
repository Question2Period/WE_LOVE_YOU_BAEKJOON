package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon9625 {
	public static int K,x,y;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		recur(1,0,K);
	}
	public static void recur(int A,int B,int K) {
		if(K==0) {
			System.out.println(x+" "+y);
			return;
		}
		x = B; // 현 시점에 생성되는 A 개수
		y = A+B; // 현 시점에 생성되는 B의 개수
		recur(x,y,K-1);		
	}

}
