package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon9658 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		if(N%7==3||N%7==1)System.out.println("CY");
		else System.out.println("SK");
		
	}

}
