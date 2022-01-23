import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon3003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] anz = {1, 1, 2, 2, 2,8};
		int[] anz2 = new int[6];
		for(int i=0; i<6; i++) {
			anz2[i]=Integer.parseInt(st.nextToken());
		}
		for(int j=0; j<6; j++) {
			anz[j]-=anz2[j];
		}
		for(int i=0; i<6; i++) {
			System.out.print(anz[i]+" ");
		}

	}
}
