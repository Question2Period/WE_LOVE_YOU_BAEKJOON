

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BaekJoon6131 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		if(a==b||(w==0 && n==0)) {
			System.out.println("1 1");
		}
		else {
			int x = (w-b*n)/(a-b);
			int y = (a*n-w)/(a-b);
			if(x<=0||y<=0){
				System.out.println("-1");
			}
			else {
				System.out.printf("%d %d",x,y);
			}
			br.close();
		}
	}
}

