package Silver;
import java.io.*;
import java.util.*;
import java.math.*;
public class BaekJoon9205 {

	public static class point implements Comparable<point>{
		int x;
		int y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(point o) {
			int a =Math.abs(this.x-start.x)+Math.abs(this.y-start.y); //나와 출발점간의 거리
			int b =Math.abs(o.x-start.x)+Math.abs(o.y-start.y);//비교대상과 출발점간의 거리
			int c =Math.abs(this.x-ex)+Math.abs(this.y-ey);//나와 도착점간의 거리
			int d =Math.abs(o.x-ex)+Math.abs(o.y-ey);//비교대상과 도착점간의 거리
			if(a==b) return c-d;//출발점간의 거리가 같으면 도착점과의 거리로 오름차순
			else return a-b;//아니라면 출발점간의 거리로 오름차순
		}
	}

	public static int n,flag,ex,ey;
	public static point start;
	public static Queue<point> pq;
	//	public static boolean
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			flag = 0;
			n = Integer.parseInt(br.readLine());
			pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			start = new point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				pq.offer(new point(x,y));
			}
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
				pq.offer(new point(ex,ey));
			while(!pq.isEmpty()) {
				pq.offer(pq.poll()); 
				//start가 바뀌었거나 (ex,ey)가 들어오기전에 큐에넣었을경우 대비 큐 업데이트
				point cur = pq.poll();//가장 가까운 지점 cur선언
				System.out.println(cur.x+" "+cur.y);
				if(manhaton(start,cur)>1000) {//가장 가까운 정점이 1000보다 멀면 sad
					flag=-1;
					break;
				}
				if(cur.x==ex&&cur.y==ey)break;//도착점 도착시 happy
				start.x=cur.x;
				start.y = cur.y;//출발점을 가장 가까운 정점정보로 업데이트
			}
			if(flag==0)System.out.println("happy");
			else System.out.println("sad");
		}
	}

	public static int manhaton(point a,point b) {//거리계산
		int d = Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
		return d;
	}

}
