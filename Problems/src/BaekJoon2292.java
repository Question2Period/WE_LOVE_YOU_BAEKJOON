import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BaekJoon2292 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=0;true;i++) {
			if(N>=3*i*i-9*i+8&&N<=3*i*i-3*i+1) {
				answer=i;
				break;
			}
		}
		if(N!=1) {
		System.out.println(answer);
	}
		else {
			System.out.println('1');
		}
	}
}

