package Bronze;
import java.io.*;

public class BaekJoon5622 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;
		for(int i = 0; i<str.length(); i++) {
			int a = str.charAt(i);
			if(a<='C')cnt+=3;
			else if(a<='F')cnt+=4;
			else if(a<='I')cnt+=5;
			else if(a<='L')cnt+=6;
			else if(a<='O')cnt+=7;
			else if(a<='S')cnt+=8;
			else if(a<='V')cnt+=9;
			else if(a<='Z')cnt+=10;
		}
		System.out.println(cnt);
	}

}
