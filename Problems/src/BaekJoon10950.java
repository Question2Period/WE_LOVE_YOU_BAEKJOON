import java.io.*;
import java.util.*;
public class BaekJoon10950 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());
		int sum = 0;

		for(int i=0; i<P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				sum+=Integer.parseInt(st.nextToken());
			}
			System.out.println(sum);
			sum=0;
		}
	}

}
