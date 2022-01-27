import java.io.*;
import java.util.*;
public class BaekJoon2839 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int min = 5000;
		for(int i = 0;i<=N/5;i++) {
			for(int j = 0;j<=N/3;j++) {
				if(5*i+3*j>N) {
					break;
				}
				if(5*i+3*j==N) {
				if(min>i+j) {
					min = i+j;
				}
				}
				else {
					continue;
				}
			}
		}
		if(min==5000) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);
		}
	}

}
