package Silver;
import java.io.*;
public class BaekJoon11653 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(N!=1) {
			for(int i = N-1; true; i--) {
				if(N%i==0) {
					sb.append(N/i).append("\n");
					N=i;
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
