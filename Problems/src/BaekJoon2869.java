import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BaekJoon2869 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\ssafy\\BaekJoon\\Problems\\src\\input2869.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); //집합 A의 원소 개수
		int b = Integer.parseInt(st.nextToken()); //집합 B의 원소 개수
		long v = Long.parseLong(st.nextToken()); //집합 B의 원소 개수
		long day=0;
		if(a==v) {
			System.out.println("1");
		}
		for(int i=1;a>b;i++) {
			day+=a;
			if(day>=v) {
				System.out.println(i);
				break;
			}
			day-=b;
		}
	}
}