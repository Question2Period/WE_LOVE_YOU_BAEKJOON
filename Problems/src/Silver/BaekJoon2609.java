package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2609 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int x = Math.min(a, b);
		int gong = 0;
		for(int i = x; i!=0; i--) {
			if(a%i==0&&b%i==0) {
				gong = i;
				break;
			}
		}
		System.out.println(gong);
		System.out.println(a*b/gong);
	}

}
