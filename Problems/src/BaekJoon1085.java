import java.io.*;
import java.util.*;
public class BaekJoon1085 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int flag = 0;
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		if(w-x<=x&&w-x<=h-y&&w-x<=y&&flag==0) {
		System.out.println(w-x);
		flag++;
		}
		if(x<=w-x&&x<=h-y&&x<=y&&flag==0) {
		System.out.println(x);	
		flag++;
		}
		if(h-y<=w-x&&h-y<=x&&h-y<=y&&flag==0) {
		System.out.println(h-y);	
		flag++;
		}
		if(y<=w-x&&y<=x&&y<=h-y&&flag==0) {
		System.out.println(y);	
		flag++;
		}

	}

}
