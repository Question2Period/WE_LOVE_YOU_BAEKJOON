package Silver;
import java.io.*;
public class BaekJoon2018 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int sum = 0;
		int p1 = 1;
		int p2 = 2;
		sum = p1+p2;
		while(p2<N&&p1!=p2) {
			if(sum<N) {
				p2++;
				sum+=p2;
				continue;
			}
			if(sum>N) {
				sum-=p1++;
			}
			if(sum==N) {
				sum-=p1++;
				count++;
			}
		}
		System.out.println(count);
	}
}
