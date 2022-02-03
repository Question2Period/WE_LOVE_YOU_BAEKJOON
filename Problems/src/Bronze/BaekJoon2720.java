package Bronze;
import java.io.*;
public class BaekJoon2720 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i =0;i<T; i++) {
			int C = Integer.parseInt(br.readLine());
			int quarter = C/25;
			int Dime = C%25/10;
			int Nickel = C%25%10/5;
			int Penny = C%25%10%5;
			System.out.printf("%d %d %d %d\n",quarter,Dime,Nickel,Penny);
		}
	}

}
