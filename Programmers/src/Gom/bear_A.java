package Gom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class bear_A {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt = 0;
		while(cnt!=N) {
			if(A/2!=0) {
				cnt++;
				A-=2;
				continue;
			}
			if(B!=0) {
				cnt++;
				B--;
				continue;
			}
			break;
		}
		System.out.println(cnt);
		
	}

}
