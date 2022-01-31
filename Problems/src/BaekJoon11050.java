import java.io.*;
import java.util.StringTokenizer;
public class BaekJoon11050 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int output = 1;
		if(N<K |K<0) {
			System.out.println(0);
		}
		else {
			for(int i = 0;i<K;i++) {
				output*=(N-i);
			}
			for(int i = 1;i<=K;i++) {
				output/=i;
			}
			System.out.println(output);
		}
	}

}
