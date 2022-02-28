package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon2527 {
	public static int x1,y1,x2,y2,x3,y3,x4,y4;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			x3 = Integer.parseInt(st.nextToken());
			y3 = Integer.parseInt(st.nextToken());
			x4 = Integer.parseInt(st.nextToken());
			y4 = Integer.parseInt(st.nextToken());
			if((x2==x3 &&y2==y3)||(x1==x4&&y2==y3)||(x2==x3 &&y1==y4)||(x1==x4 && y1==y4)) {
				System.out.println('c');
			}
			else if(x2<x3||x4<x1||y3>y2||y4<y1)System.out.println('d');
			else if((x1==x4&&y1!=y4)||(y2==y3&&x4!=x1)||(x3==x2&&y2!=y3)||(y1==y4&&x3!=x2)) {
				System.out.println('b');
			}
		
			else System.out.println('a');
			
		}
	}

}
