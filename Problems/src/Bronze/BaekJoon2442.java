package Bronze;
import java.io.*;
public class BaekJoon2442 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i =0; i<N; i++) {
			for(int k =0; k<N-1-i; k++) {
				System.out.print(" ");
			}
			for(int j = 0; j<2*i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
