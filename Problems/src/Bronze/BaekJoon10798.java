package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon10798 {
	public static String str;
	public static char[][] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		arr = new char[5][15];
		StringTokenizer st;
		for(int i =0; i<5; i++) {
			str = br.readLine();
			for(int j = 0; j<str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for(int i = 0; i<15; i++) {
			for(int j =0; j<5; j++) {
				if(arr[j][i]==0)continue;
				sb.append(arr[j][i]);
			}
		}
		System.out.println(sb);
	}

}
