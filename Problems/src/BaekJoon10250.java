import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BaekJoon10250 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("C:\\ssafy\\BaekJoon\\Problems\\src\\input2869.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;
		for(int i=0;i<T;i++) {
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		if(N%H==0) {
		x = N/H;
		y = H*100;
		}
		else {
		x = (N/H)+1;	
		y = (N%H)*100;
		}
		System.out.println(x+y);
		}
	}
}