package Beginner;
import java.io.*;
import java.util.*;
import java.util.*;
public class B_20220227 {
	public static int plan,flag;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());//라면 개수
		int M = Integer.parseInt(st.nextToken()); //계획 일 수
		boolean[] ate = new boolean[N];
		int[] Noodle = new int[N];
		st = new StringTokenizer(br.readLine()); // 라면 길이 입력
		for(int i = 0; i<N; i++) {
			Noodle[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()); //날짜 별 길이 입력
		for(int j = 0; j<M; j++) {
			flag = 0;
			plan = Integer.parseInt(st.nextToken());
			for(int k = 0; k<N; k++) {
				if(!ate[k]&&Noodle[k]==plan) {
					ate[k] =true;
					flag = -1;
					break;
				}
			}
			if(flag==0) {
				System.out.println("No");
				break;
			}
		}
		if(flag!=0)System.out.println("Yes");
		
	}

}
