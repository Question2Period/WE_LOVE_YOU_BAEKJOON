package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon10158 {
	public static int[] dx = {1,-1,-1,1};//우상, 좌상, 좌하, 우하 대각
	public static int[] dy = {1,1,-1,-1};
	public static int[][] arr;
	public static int w,h,x,y,t,dif;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h+1][w+1];
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(br.readLine());
		dif = Math.min(w-x, h-y);
		if(dif==(w-x))x=w;
		else y=h;
		t-=dif;
		while(t!=0) {
			for(int i = 0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
			}
			while(x<)
		}
	}

}
