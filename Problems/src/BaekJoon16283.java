import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon16283 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int A = 1;
		int B = 1;
		int count = 0;
		for(A=1; A<=500;A++) {
			for(B=1;B<A;B++) {
				if(A*A==B*B+N) {		
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
//l