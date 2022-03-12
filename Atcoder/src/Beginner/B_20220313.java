package Beginner;
import java.io.*;
import java.util.*;

public class B_20220313 {
	public static int first,second;
	public static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++)list.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(list.contains(num)) {
				if(list.indexOf(num)==i) {
					first++;
					continue;
				}
				second++;
			}
		}
		System.out.println(first);
		System.out.println(second);
		

	}

}
//A와 B 각각 서로 다른 정수의 수열?
// 조건 1: 같은 자리에 같은 숫자가 나타나게?
// 조건 2 : 다른 자리에 같은 숫자가 나타나게
