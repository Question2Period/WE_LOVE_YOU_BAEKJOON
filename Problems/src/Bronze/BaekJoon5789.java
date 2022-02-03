package Bronze;
import java.io.*;
public class BaekJoon5789 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			String str = br.readLine();
			if(str.charAt(str.length()/2)==str.charAt((str.length()/2)-1)) {
				System.out.println("Do-it");
			}
			else{
				System.out.println("Do-it-Not");
			}
		}
	}

}
