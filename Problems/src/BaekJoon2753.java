import java.io.*;
import java.util.*;
public class BaekJoon2753 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		if(input%4==0 && input%100!=0) {
			System.out.println('1');
		}
		else if(input%400==0){
			System.out.println('1');
		}
		else {
			System.out.println('0');
		}
	}
}
