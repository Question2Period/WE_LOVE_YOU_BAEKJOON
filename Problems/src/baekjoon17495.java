package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Math;
public class baekjoon17495 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a =Integer.parseInt(st.nextToken());
		int b =Integer.parseInt(st.nextToken());
		int x = -a + (int)Math.sqrt(a*a-b) ;
		int y = -a - (int)Math.sqrt(a*a-b) ;
		if(x==y) {
			System.out.println(x);
		}
		else{
			System.out.println(y +" "+ x);
		}

	}
}
