package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon10158 {

	public static int w,h,x,y,t,a,b;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(br.readLine());
		a = w-Math.abs(w-(x+t)%(2*w));
		b = h-Math.abs(h-(y+t)%(2*h));
		System.out.print(a);
		System.out.print(" ");
		System.out.print(b);
		br.close();
	}
}