package Beginner;
import java.io.*;
import java.util.*;

public class A_20220312 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		while(true) {
			V-=A;
			if(V<0) {
				System.out.println("F");
				break;
			}
			V-=B;
			if(V<0) {
				System.out.println("M");
				break;
			}
			V-=C;
			if(V<0) {
				System.out.println("T");
				break;
			}
		}
	}

}
