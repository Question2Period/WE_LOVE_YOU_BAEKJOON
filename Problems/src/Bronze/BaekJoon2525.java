package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon2525 {
	public static int time,minute;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(br.readLine());
		int Sum = 60*A+B+C;
		if(Sum/60>=24)time=Sum/60-24;
		else time=Sum/60;
		minute = Sum%60;
		System.out.println(time+" "+minute);
	}

}
