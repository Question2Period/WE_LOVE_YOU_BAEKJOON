package Bronze;
import java.io.*;
public class BaekJoon10039 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i = 0; i<5; i++) {
			int a= Integer.parseInt(br.readLine());
			if(a<=40) sum+=40;
			else sum+=a;
		}
		System.out.println(sum/5);
	}

}
