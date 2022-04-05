package Silver;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class BaekJoon2407 {
	public static int N;
	public static int M;
	public static int []arr = new int[110];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");

		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		BigInteger n1 = BigInteger.ONE;
		BigInteger n2 = BigInteger.ONE;

		for (int i = 0; i < m; i++) {
			n1 = n1.multiply(new BigInteger(String.valueOf(n - i)));
			n2 = n2.multiply(new BigInteger(String.valueOf(i + 1)));
		}

		BigInteger answer = n1.divide(n2);

		System.out.println(answer);
	}
}
