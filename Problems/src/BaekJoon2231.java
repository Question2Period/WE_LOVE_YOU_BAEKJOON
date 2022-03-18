import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BaekJoon2231 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int flag = 0;
		for(int i= 1; i<=1000000; i++) {
			String str= Integer.toString(i);
			int sum = 0;
			for(int j = 0; j<str.length(); j++)sum+=(str.charAt(j)-'0');
			if(Integer.parseInt(str)+sum!=N)continue;
			System.out.println(str);
			flag=1;
			break;
		}
		if(flag==0)System.out.println(0);
	}
}