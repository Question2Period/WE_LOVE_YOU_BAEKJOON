import java.io.*;
public class BaekJoon15829 {
	static final int M = 1234567891;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		long sum = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		for(int i = 0; i< L; i++) {
			sum+=(str.charAt(i) -96)*pow(i);
		}
		System.out.println(sum%M);
	}
	static long pow(int a) {
		return a==0? 1 : 31*pow(a-1)%M;
	}
}
