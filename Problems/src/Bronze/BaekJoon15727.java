package Bronze;
import java.io.*;
public class BaekJoon15727 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		if(L%5!=0) {
			System.out.println(L/5+1);
		}
		else {
			System.out.println(L/5);
		}
	}

}
