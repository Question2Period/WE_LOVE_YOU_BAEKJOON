package Midas;

public class skt2 {
	public static int[][] answer;
	public static int[] dx1= {0,1,0,-1};//우하좌상
	public static int[] dy1= {1,0,-1,0};
	public static int[] dx2= {1,0,-1,0};//하좌상우
	public static int[] dy2= {0,-1,0,1};
	public static int[] dx3= {-1,0,1,0};//상우하좌
	public static int[] dy3= {0,1,0,-1};
	public static int[] dx4= {0,-1,0,1};//좌상우하
	public static int[] dy4= {-1,0,1,0};
	public static int[] dx5= {1,0,-1,0};//하우상좌
	public static int[] dy5= {0,1,0,-1};
	public static int[] dx6= {0,1,0,-1};//좌하우상
	public static int[] dy6= {-1,0,1,0};
	public static int[] dx7= {0,-1,0,1};//우상좌하
	public static int[] dy7= {1,0,-1,0};
	public static int[] dx8= {-1,0,1,0};//상좌하우
	public static int[] dy8= {0,-1,0,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		boolean clockwise = false;
		answer = new int[n][n];
		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = n-1;
		int x3 = n-1;
		int y3 = 0;
		int x4 = n-1;
		int y4 = n-1;
		int count = 1;	
		answer[x1][y1]=answer[x2][y2]=answer[x3][y3]=answer[x4][y4]=count;
	
		if(clockwise) {
			while(true) {
				if(answer[n/2][n/2]!=0)break;
				for(int i = 0; i<4; i++) {
				int nx1 = x1+dx1[i];
				int ny1 = y1+dy1[i];
				int nx2 = x2+dx2[i];
				int ny2 = y2+dy2[i];
				int nx3 = x3+dx3[i];
				int ny3 = y3+dy3[i];
				int nx4 = x4+dx4[i];
				int ny4 = y4+dy4[i];
				while(true) {
					count++;
					if(answer[nx1][ny1]!=0)break;
					if(nx1<0||nx1>n-1||ny1<0||ny1>n-1)break;
					answer[nx1][ny1]=answer[nx2][ny2]=answer[nx3][ny3]=answer[nx4][ny4]=count;
					nx1 +=dx1[i];
					ny1 +=dy1[i];
					nx2 +=dx2[i];
					ny2 +=dy2[i];
					nx3 +=dx3[i];
					ny3 +=dy3[i];
					nx4 +=dx4[i];
					ny4 +=dy4[i];
				}
				x1=nx1-dx1[i];
				x2=nx2-dx2[i];
				x3=nx3-dx3[i];
				x4=nx4-dx4[i];
				y1=ny1-dy1[i];
				y2=ny2-dy2[i];
				y3=ny3-dy3[i];
				y4=ny4-dy4[i];
				count--;
				}
			}
		}
		else {
			while(true) {
				if(answer[n/2][n/2]!=0)break;
				for(int i = 0; i<4; i++) {
					int nx1 = x1+dx5[i];
					int ny1 = y1+dy5[i];
					int nx2 = x2+dx6[i];
					int ny2 = y2+dy6[i];
					int nx3 = x3+dx7[i];
					int ny3 = y3+dy7[i];
					int nx4 = x4+dx8[i];
					int ny4 = y4+dy8[i];
				while(true) {
					count++;
					if(answer[nx1][ny1]!=0)break;
					if(nx1<0||nx1>n-1||ny1<0||ny1>n-1)break;
					answer[nx1][ny1]=answer[nx2][ny2]=answer[nx3][ny3]=answer[nx4][ny4]=count;
					nx1 +=dx5[i];
					ny1 +=dy5[i];
					nx2 +=dx6[i];
					ny2 +=dy6[i];
					nx3 +=dx7[i];
					ny3 +=dy7[i];
					nx4 +=dx8[i];
					ny4 +=dy8[i];
				}
				x1=nx1-dx5[i];
				x2=nx2-dx6[i];
				x3=nx3-dx7[i];
				x4=nx4-dx8[i];
				y1=ny1-dy5[i];
				y2=ny2-dy6[i];
				y3=ny3-dy7[i];
				y4=ny4-dy8[i];
				count--;
				}
			}
		}
		for(int i = 0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
//class Solution {
//    public int[][] solution(int n, boolean clockwise) {
//        int[][] answer = {};
//        return answer;
//    }
//}
