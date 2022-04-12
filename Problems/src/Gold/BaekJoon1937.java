package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon1937 {
	
	static class info{
		int x;
		int y;
		public info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static List<info> chicken;
	public static List<info> home;
	public static boolean[] burn;
	public static int N,M,min;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		for(int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==2)chicken.add(new info(i,j));
				else if(a==1)home.add(new info(i,j));
			}
		}
		burn = new boolean[chicken.size()];
		min = Integer.MAX_VALUE;
		partition(0);
		System.out.println(min);
		
	}
	
	public static void partition(int cur) {// 전체 수행 메서드
		
		if(cur==chicken.size()) {
			if(check())return;
			min = Math.min(min, citydistance());
			return;
		}
		burn[cur] = true;//폐업
		partition(cur+1);
		burn[cur] = false;//개업
		partition(cur+1);
	}
	
	public static int citydistance() {//도시 치킨거리
		int distance = 0;
		for(int i = 0; i<home.size(); i++) {
			distance+=manhaton(i);
		}
		return distance;
	}
	
	public static int manhaton(int h) { // 집-치킨집 최소거리
		int mindist = 1000000;
		int homex = home.get(h).x;
		int homey = home.get(h).y;
		for(int i =0; i<chicken.size(); i++) {
			if(burn[i])continue;
			int dist = Math.abs(homex-chicken.get(i).x)+Math.abs(homey-chicken.get(i).y);
			mindist = Math.min(mindist,dist );
		}
		return mindist;
	}
	
	public static boolean check() {//치킨집 다 폐업시키면 안되므로 체크
		int time = 0;
		for(int i = 0;i<burn.length; i++ ) {
			if(!burn[i]) time++;//열려있다면 +
		}
		if(time==0||time>M)return true; //개업 개수를 초과하거나 전부 폐업일경우
		else return false;
	}

}
