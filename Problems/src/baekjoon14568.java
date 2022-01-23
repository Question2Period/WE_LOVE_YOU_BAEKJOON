
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BaekJoon14568 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int count = 0;
		for(int i=1;i<N/2;i++) {
			
			for(int j=1; N-2*i-2*j>=2;j++) {
				count++;
			}
		}
		System.out.println(count);
	}
}	