package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon4446 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] v = {'a'-'a','i'-'a','y'-'a','e'-'a','o'-'a','u'-'a'};//모음
		int[] c = {'b','k','x','z','n','h','d','c','w','g','p','v','j','q','t','s','r','l'
					,'m','f'};
		StringBuilder sb = new StringBuilder();
		for(int i= 0; i<20; i++) {
			c[i]-='a';
		}
		String str="";
		while((str=br.readLine())!=null){	
		for(int i = 0; i<str.length(); i++) {
			int after = 0;
			int cur = str.charAt(i);
			if(cur>=65&&cur<=90) {
				cur-='A';
				after = 'A';
			}
			else if(cur>=97&&cur<=122) {
				cur-='a';
				after = 'a';
				
			}
			else {
				System.out.print((char)cur);
				continue;
			}
			int index = -1;
			for(int j = 0; j<6; j++) {
				if(v[j]==cur) {
					index=(j+3)%6;
					System.out.print((char)(v[index]+after));
					break;
				}
			}
			if(index<0) {
				for(int j = 0; j<20; j++) {
					if(c[j]==cur) {
						index=(j+10)%20;
						System.out.print((char)(c[index]+after));
						break;
					}
				}
			}
		}
		System.out.print("\n");
		}
		
	}

}
