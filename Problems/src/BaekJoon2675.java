import java.io.*;
public class BaekJoon2675 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			int repeat = (str.charAt(0)-'0');
			for(int j=0;j<str.length()-2;j++) {
				for(int k=0;k<repeat;k++) {
					System.out.print(str.charAt(j+2));
				}
			}
			System.out.println();
		}

	}

}
