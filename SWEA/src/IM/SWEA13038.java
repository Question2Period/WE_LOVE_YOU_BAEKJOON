package IM;
import java.io.*;
import java.util.*;
public class SWEA13038 {
	public static int[] arr;
	public static int day,count,index;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			day = 0;
			count = 0;
			int n = Integer.parseInt(br.readLine());
			arr = new int[8];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i =1; i<=7; i++) {
				if(arr[i]==1) {
					index=i;
					break;
				}
			}
			for(int j = index; j<=7; j++) {
				day++;
				if(arr[j]==1)count++;
				if(count==n)break;
			}
			if(count!=n) {
			while(true) {
				for(int j = 1; j<=7; j++) {
					day++;
					if(arr[j]==1)count++;
					if(count==n)break;
				}
				if(count==n)break;
			}
			}
			System.out.println("#"+t+" "+day);
		}
		
	}

}
