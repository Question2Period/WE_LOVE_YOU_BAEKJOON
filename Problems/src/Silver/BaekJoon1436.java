package Silver;
import java.io.*;
public class BaekJoon1436 { // 영화감독 숌 실버 5

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String str="";
		int check = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 666; i<1000000000;i++) {
			str = i+"";
			for(int j = 0; j<str.length()-2;j++) {
				if(str.charAt(j)=='6'&&str.charAt(j+1)=='6'&&str.charAt(j+2)=='6') {
						check++;
						break;
					}
			}

			if(check==N) {
				break;
			}
		}
		System.out.println(str);
	}

}
