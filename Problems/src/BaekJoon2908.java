import java.io.*;
import java.util.*;
public class BaekJoon2908 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		if(a==0&&b<45) {
			a=24;
		}
		int time = 60*a+b-45;
		System.out.printf("%d %d",time/60,time%60);
	}
}
