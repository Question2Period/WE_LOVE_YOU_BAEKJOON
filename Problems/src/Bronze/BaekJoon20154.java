package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon20154 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int L = str.length();
		int sum = 0;
		int[] arr = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
		for(int i = 0; i<L; i++) {
			sum+=arr[str.charAt(i)-'A'];
		}
		if(sum%2==0)System.out.println("You're the winner?");
		else System.out.println("I'm a winner!");
	}

}
