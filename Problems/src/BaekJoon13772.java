import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BaekJoon13772 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("C:\\ssafy\\BaekJoon\\Problems\\src\\input2869.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count=0;
		int n = Integer.parseInt(st.nextToken()); //집합 A의 원소 개수
		String str="hi";
		for(int j=0;j<n;j++) {
		str = br.readLine();
		}
		for(int i=0;i<str.length();i++) {
			switch (str.charAt(i)-'0') {
			case 'A':
				count++;
				break;
			case 'B':
				count+=2;
				break;
			case 'D':
				count++;
				break;
			case 'O':
				count++;
				break;
			case 'P':
				count++;
				break;
			case 'Q':
				count++;
				break;
			case 'R':
				count++;
				break;
			default:
				break;
			}			
		}
		System.out.println(count);
	}
}