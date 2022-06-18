package Bronze;
import java.io.*;
public class BaekJoon5585 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int change = 1000 - Integer.parseInt(br.readLine());
		int[] wallet = new int[6];
		wallet[0] = 500;
		wallet[1] = 100;
		wallet[2] = 50;
		wallet[3] = 10;
		wallet[4] = 5;
		wallet[5] = 1;
		
		int cnt = 0;
		for(int i = 0; i<6; i++) {
			cnt+=(change/wallet[i]);
			change%=wallet[i];
		}
		System.out.println(cnt);
	}

}
