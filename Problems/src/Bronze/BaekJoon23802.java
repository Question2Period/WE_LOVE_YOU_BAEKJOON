package Bronze;
import java.io.*;
public class BaekJoon23802 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<5*N; j++) {
				System.out.print("@");
			}
			System.out.println();
		}
		for(int i = 0; i<4*N; i++) {
			for(int j = 0; j<N;j++) {
				System.out.print("@");
			}
			System.out.println();
		}
	}

}
