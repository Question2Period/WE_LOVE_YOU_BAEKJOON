package Beginner;
import java.io.*;
import java.util.*;
import java.util.*;
public class B_20220423 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] check = new int[123];
		String str = br.readLine();
		for(int i= 0; i<str.length(); i++) {
			int index = str.charAt(i);
			check[index]++;
		}
		int count1 = 0;//대문자
		int count2 = 0;//소문자
		int count3 = 0;//중복
		for(int i= 65; i<=90; i++) {//대문자들
			if(check[i]==1)count1++;
			if(check[i]==2) count3++;
		}
			for(int i= 97; i<=122; i++) {
				if(check[i]==1)count2++;
				if(check[i]==2) count3++;
			}
			if(count1==0||count2==0||count3!=0)System.out.println("No");
			else System.out.println("Yes");

	}
}
