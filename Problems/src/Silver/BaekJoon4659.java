package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon4659 {
	public static int[] v = {'a','e','i','o','u'};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while(true) {
			str = br.readLine();
			if(str.equals("end"))break;
			int first = 0;
			int second = 0;
			int third = 0;
			int ja = 0;// 
			int mo = 0;// 
			for(int i = 0; i<str.length();i++) {
				int a = str.charAt(i);
				int search = Arrays.binarySearch(v, a);
				if(search<0) {//자음
					ja++;
					mo=0;
				}
				else {//모음
					mo++;
					ja=0;
					first=1;
				}
				if(ja>=3||mo>=3) {
					second=1;
					break;
				}
				
				if(i!=0) {
					if(a==str.charAt(i-1)) {
						if((a=='o'&&str.charAt(i-1)=='o')||(a=='e'&&str.charAt(i-1)=='e')) {
							continue;
						}
						third = 1;
						break;
					}
				}
			}
			if(first!=1) {//1번 충족 실패
				System.out.print("<"+str+"> is not acceptable.");
				System.out.print("\n");
				continue;
			}
			if(second==1) {//2번 충족 실패
				System.out.print("<"+str+"> is not acceptable.");
				System.out.print("\n");
				continue;
			}
			if(third==1) {//3번 충족 실패
				System.out.print("<"+str+"> is not acceptable.");
				System.out.print("\n");
				continue;
			}
			System.out.print("<"+str+"> is acceptable.");
			System.out.print("\n");
		}
	}

}
