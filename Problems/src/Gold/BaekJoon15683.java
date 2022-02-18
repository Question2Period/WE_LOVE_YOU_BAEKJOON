package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon15683 {
	public static int[][] arr;
	public static int N,M,square,Max;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	
	public static void Gamsi(int x, int y, int sum) {
		if(x==N && y==M) {
			square -= Max;
			return;
		}
		if(x>N) Gamsi(x-N,y,sum);
		else if(y>M) Gamsi(x,y-M,sum);
		
		if(arr[x][y]==0) Gamsi(x+1,y,sum+1);
		else if(arr[x][y]==1) {
			while((x<=N && x>=1)|(y<=M && y>=1)) {
				switch
			}
		}
	}
	
	public static int check(int x, int y,int CCTV) {// 0:좌 1:상 2:우 3:하
		int direction=0;
		int Left = left(x,y);
		int Right = right(x,y);
		int Top = top(x,y);
		int Bottom = bottom(x,y);
		int a;
		int b;
		switch (CCTV) {
		case 1:
			a = Math.max(Left, Right);
			b = Math.max(Top, Bottom);
			direction = Math.max(a, b);
			if(direction==Left) direction=0;
			else if(direction==Top)direction=1;
			else if(direction==Right)direction=2;
			else direction=3;
			break;
		case 2:
			a=Left+Right;
			b=Top+Bottom;
			direction = Math.max(a, b);	
			if(direction==Left+Right) direction=0;
			else if(direction==Top+Bottom)direction=1;
			break;
		case 3:
			a = Math.max(Top+Right, Right+Bottom);
			b = Math.max(Bottom+Left, Left+Top);
			direction = Math.max(a, b);
			if(direction==Top+Right) direction=0;
			else if(direction==Right+Bottom)direction=1;
			else if(direction==Bottom+Left)direction=2;
			else if(direction==Left+Top)direction=3;
			break;

		case 4:
			a = Math.max(Top+Right+Bottom, Right+Bottom+Left);
			b = Math.max(Bottom+Left+Top, Left+Top+Right);
			direction = Math.max(a, b);
			if(direction==Top+Right+Bottom) direction=0;
			else if(direction==Right+Bottom+Left)direction=1;
			else if(direction==Bottom+Left+Top)direction=2;
			else if(direction==Left+Top+Right)direction=3;
			break;
		}
		return direction;
	}
	
	
	
	public static int left(int x, int y) {
		int result = 0;
		while(x>=1) {
			if(arr[x][y]==0) result++;
			else if(arr[x][y]==6)break;
			x--;
		}
		return result;
	}
	public static int right(int x, int y) {
		int result = 0;
		while(x<=N) {
			if(arr[x][y]==0) result++;
			else if(arr[x][y]==6)break;
			x++;
		}
		return result;
	}
	public static int top(int x, int y) {
		int result = 0;
		while(y>=1) {
			if(arr[x][y]==0) result++;
			else if(arr[x][y]==6)break;
			y--;
		}
		return result;
	}
	public static int bottom(int x, int y) {
		int result = 0;
		while(y<=M) {
			if(arr[x][y]==0) result++;
			else if(arr[x][y]==6)break;
			y++;
		}
		return result;
	}
}
