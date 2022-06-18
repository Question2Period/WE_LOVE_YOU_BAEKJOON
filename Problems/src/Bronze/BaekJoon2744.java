package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon2744 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		for(int i = 0; i<str.length(); i++) {
			int index = str.charAt(i);
//			System.out.println(index-32);
//			System.out.println((char)(index-32));
			if(index>='A'&&index<='Z')sb.append((char)(index+32));
			else if(index>='a'&&index<='z') sb.append((char)(index-32));
		}
		System.out.println(sb);
	}

}
