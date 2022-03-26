package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon1991 {
	public static int[] left;
	public static int[] right;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		left = new int[N+1];
		right = new int[N+1];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = st.nextToken().charAt(0)-'A'+1;
			int a2 = st.nextToken().charAt(0)-'A'+1;
			int a3 = st.nextToken().charAt(0)-'A'+1;
			left[a1] = a2;
			right[a1] = a3;
		}	
		first(1);
		System.out.println();
		middle(1);
		System.out.println();
		last(1);
	}

	public static void first(int myself) {
		if(myself==-18) return;
		System.out.print((char)(myself-1+'A'));
		first(left[myself]);
		first(right[myself]);
	}
	public static void middle(int myself) {
		if(myself==-18) return;
		middle(left[myself]);
		System.out.print((char)(myself-1+'A'));
		middle(right[myself]);
	}
	public static void last(int myself) {
		if(myself==-18) return;
		last(left[myself]);
		last(right[myself]);
		System.out.print((char)(myself-1+'A'));
	}
	
}
