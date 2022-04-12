package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon2661 { //블로그 많이 참고. 다시풀기
	public static int N;
	//	public static List<String>list;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		recur("");

	}

	public static void recur(String str) {
		
		if(str.length()==N) {
			System.out.println(str);
			System.exit(0);

		}
		else
		for(int i = 1; i<=3; i++) {
			if(check(str+i))continue;
			recur(str+i);
		}

	}

	public static boolean check(String x) {
		int l = x.length()/2;
		for(int i = 1; i<=l; i++) {
			String a = (x.substring(x.length()-i));
			String b = x.substring(x.length()-2*i,x.length()-i);
			if(a.equals(b))return true;//하나라도 다른게 있다면 체크
		}

		return false;
	}



}
