package WATER;
import java.io.*;
import java.util.*;
public class Inha {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		float num = 0;
		float sum = 0;
		for(int i = 0; i<20; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			float ca = Float.parseFloat(st.nextToken());
			String str = st.nextToken();
			if(str.equals("P"))continue;
			num+=ca;			
			switch (str) {
			case "A+":
				sum+=(ca*4.5);
				break;
				
			case "A0":
				sum+=(ca*4.0);
				break;
				
			case "B+":
				sum+=(ca*3.5);
				break;
				
			case "B0":
				sum+=(ca*3.0);
				break;
				
			case "C+":
				sum+=(ca*2.5);
				break;
				
			case "C0":
				sum+=(ca*2.0);
				break;
				
			case "D+":
				sum+=(ca*1.5);
				break;
				
			case "D0":
				sum+=(ca*1.0);
				break;
			}
		}
		System.out.println(sum/num);
	}

}
