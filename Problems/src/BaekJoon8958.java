import java.io.*;
public class BaekJoon8958 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int Score = 1;
		int Sum = 0;
		for(int i=0; i<N; i++) {
			Sum=0;
			Score=0;
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='O') {
					Score++;
					Sum+=Score;
					continue;
				}
				Score=0;
			}
			sb.append(Sum).append("\n");
		}
		System.out.println(sb);
	}
}