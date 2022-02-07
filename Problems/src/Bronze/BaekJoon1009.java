package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon1009 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a%10==1) {
				System.out.println(1);
			}
			else if(a%10==2) {
				if(b%4==1) {
					System.out.println(2);
				}
				else if(b%4==2) {
					System.out.println(4);
				}
				else if(b%4==3) {
					System.out.println(8);
				}
				else if(b%4==0) {
					System.out.println(6);
				}
			}
			else if(a%10==3) {
				if(b%4==1) {
					System.out.println(3);
				}
				else if(b%4==2) {
					System.out.println(9);
				}
				else if(b%4==3) {
					System.out.println(7);
				}
				else if(b%4==0) {
					System.out.println(1);
				}
			}
			else if(a%10==4) {
				if(b%2==1) {
					System.out.println(4);
				}
				else if(b%2==0) {
					System.out.println(6);
				}
			}
			else if(a%10==5) {
				System.out.println(5);
			}
			else if(a%10==6) {
				System.out.println(6);
			}
			else if(a%10==7) {
				if(b%4==1) {
					System.out.println(7);
				}
				else if(b%4==2) {
					System.out.println(9);
				}
				else if(b%4==3) {
					System.out.println(3);
				}
				else if(b%4==0) {
					System.out.println(1);
				}
			}
			else if(a%10==8) {
				if(b%4==1) {
					System.out.println(8);
				}
				else if(b%4==2) {
					System.out.println(4);
				}
				else if(b%4==3) {
					System.out.println(2);
				}
				else if(b%4==0) {
					System.out.println(6);
				}
			}
			else if(a%10==9) {
				if(b%2==1) {
					System.out.println(9);
				}
				else if(b%2==0) {
					System.out.println(1);
				}
			}
			else if(a%10==0) {
				System.out.println(10);
			}
		}
	}

}
