package Bronze;
import java.io.*;
import java.util.*;
public class BaekJoon3029 {
	public static int flag,total,time,minute,second;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str1 = br.readLine();
		st = new StringTokenizer(str1,":");
		int[] start = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		String str2 = br.readLine();
		st = new StringTokenizer(str2,":");
		int[] end = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};

		if(str1.equals(str2))System.out.println("24:00:00");
		else {
			for(int i = 0; i<3; i++) {
				if(start[i]>end[i]) {
					flag=1;
					break;
				}
				else if(start[i]<end[i]) {
					flag=2;
					break;
				}
			}
			if(flag==1) {
				total=3600*24-3600*start[0]-60*start[1]-start[2]+3600*end[0]+60*end[1]+end[2];
				time=total/3600;
				minute= total%3600/60;
				second = total%3600%60;
				if(time<10)sb.append("0"+time+":");
				else sb.append(time+":");
				if(minute<10)sb.append("0"+minute+":");
				else sb.append(minute+":");
				if(second<10)sb.append("0"+second);
				else sb.append(second);
			}
			else if(flag==2) {
				total=3600*end[0]+60*end[1]+end[2]-3600*start[0]-60*start[1]-start[2];
				time=total/3600;
				minute= total%3600/60;
				second = total%3600%60;
				if(time<10)sb.append("0"+time+":");
				else sb.append(time+":");
				if(minute<10)sb.append("0"+minute+":");
				else sb.append(minute+":");
				if(second<10)sb.append("0"+second);
				else sb.append(second);
			}
			System.out.println(sb);
		}
	}

}
