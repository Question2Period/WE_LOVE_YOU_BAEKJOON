import java.io.*;
import java.util.*;
public class BaekJoon16561 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = 0;
		int b = 0;
		int c = 0;
		int count = 0;
		for(int i = 1; i<=n/3;i++) {
			a = 3*i;
			for(int j = 1; j<=n/3; j++) {
				b = 3*j;
				for(int k = 1; k<=n/3; k++) {
					c = 3*k;
					if(a+b+c==n) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}

}
