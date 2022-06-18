package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1213 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sum = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		StringBuilder middle = new StringBuilder();
		
		int leng = str.length();
		int req = leng/2;
		int[] count = new int['Z'-'A'+1];
		for(int i =0; i<leng; i++) {
			int index = str.charAt(i)-'A';
			count[index]++;
		}
		for(int i =0; i<count.length; i++) {
			if(count[i]%2!=0) {
				middle.append((char)(i+'A'));
				count[i]--;
			}
			if(count[i]>=2) {
				while(count[i]>=2) {
					temp.append((char)(i+'A'));
					count[i]-=2;
				}
			}
		}
		sum.append(temp.toString()+middle.toString()+temp.reverse().toString());
		if(middle.length()<=1) {
			System.out.println(sum);
		}
		else System.out.println("I'm Sorry Hansoo");
		
	}

}
