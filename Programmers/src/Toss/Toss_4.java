package Toss;
import java.io.*;
import java.util.*;
public class Toss_4 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String[] ledgers = {"04/01 1 40000","05/01 5 20000","08/31 4 10000","11/11 0 -45000"};
		
        StringTokenizer st;
		
		int[] day = {0,30,60,90,120,150,180,210,243,273,304,334}; //n월 m일 = day[n-1]+m
		int answer = 0;//이자
		int[][] money = new int[3][366];
		for(int i = 0; i<ledgers.length; i++) {
			st = new StringTokenizer(ledgers[i]," ");
			String calender = st.nextToken();
			int percent = Integer.parseInt(st.nextToken());
			int inout = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(calender,"/");
			int index = day[Integer.parseInt(st.nextToken())-1]+Integer.parseInt(st.nextToken());//일 수
			money[1][index] = percent; //이율
			money[2][index] = inout; //입출금금액
		}
		
		for(int i = 1; i<=365; i++) {
			if(money[2][i]==0)continue;
			if(money[2][i]<0) {
				int out = Math.abs(money[2][i]);
					for(int j = i-1; j>=1; j--) {
						if(money[2][j]==0)continue;
						if(out-money[2][j]<=0) {
							money[2][j]-=out;
							double process1 = (double)(out*money[1][j]);
							double process2 = (double)process1/100;
							double process3 = (double)process2*(i-j);
							answer+=process3/365;
							break;
						}
						out-=money[2][j]; //남은 출금액
						double process1 = (double)(money[2][j]*money[1][j]);
						double process2 = (double)process1/100;
						double process3 = (double)process2*(i-j);
						answer+=process3/365;
						money[2][j] = 0; //이자 계산 후 입금액 0
					}
					money[2][i] =0; // 출금액 다 소진시 0
				}
			}
		
		for(int i = 1; i<=365; i++) {
			if(money[2][i]!=0) {
				double process1 = (double)(money[2][i]*money[1][i]);
				double process2 = (double)process1/100;
				double process3 = (double)process2*(365-i);
				answer+=process3/365;
			}
		}
		System.out.println(answer);
    }
}
