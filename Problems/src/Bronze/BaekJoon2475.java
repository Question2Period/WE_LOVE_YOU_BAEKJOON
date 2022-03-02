package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon2475 {
	public static int sum,num;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i<5; i++) {
			num=Integer.parseInt(st.nextToken());
			sum+=num*num;
		}
		System.out.println(sum%10);
	}

}
