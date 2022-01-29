package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon2948 { //2009년 브론즈 2

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		while(M!=1) {
			if(M<=8) {
			if((M-1)%2==1) {
				count+=31;
			}
			else if(M-1==2){
				count+=28;
			}
			else if(M-1==8) {
				count+=31;
			}
			else {
				count+=30;
			}
			}
			else {
				if((M-1)%2==1) {
					count+=30;
				}
				else {
					count+=31;
				}

			}
			M--;	
		}
		int day = (count+D-1)%7;
		switch(day) {
		case 0 :System.out.println("Thursday"); break;
		case 1 :System.out.println("Friday"); break;
		case 2 :System.out.println("Saturday"); break;
		case 3 :System.out.println("Sunday"); break;
		case 4 :System.out.println("Monday"); break;
		case 5 :System.out.println("Tuesday"); break;
		case 6 :System.out.println("Wednesday"); break;
		
		}
	}
}
