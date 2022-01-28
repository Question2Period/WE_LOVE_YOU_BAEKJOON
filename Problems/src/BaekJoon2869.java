import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BaekJoon2869 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("C:\\ssafy\\BaekJoon\\Problems\\src\\input2869.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()); 
		int b = Integer.parseInt(st.nextToken()); 
		int v = Integer.parseInt(st.nextToken());
		int c = v-a;
		int d = a-b;
		int day = 0;
		day = c/d+1;
		if(c%d!=0) {
			day++;
		}
		System.out.println(day);

	}
}