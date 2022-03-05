import java.io.*;
import java.util.*;
public class Solution {
	public static int[][] time ;
	public static int[] monthday = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static int[] money;	
	public static int[] year = new int[366];
	public static String date;
	public static int num,month,day,bronze,silver,gold,plantinum,dia;
	public int[] solution(String[] purchase){
		StringTokenizer st;
		int L = purchase.length; //구매 횟수
		time = new int[2][L]; //월,일을 기록할 배열
		money = new int[L]; //그때의 구매 금액
		for(int i = 0; i<L; i++) {
			st = new StringTokenizer(purchase[i]);
			date = st.nextToken(); //연월일 문자열
			num = Integer.parseInt(st.nextToken());//구매금액
			st = new StringTokenizer(date,"/");
			st.nextToken();//2019년
			month = Integer.parseInt(st.nextToken());//월
			day = Integer.parseInt(st.nextToken());//일
			time[0][i] = month; //0행에 월 저장
			time[1][i] = day; //1행에 일 저장
			money[i] = num; // 구매금액 저장
		}
		for(int i = 0; i<L; i++) {
			int period = time[1][i]; //금액 효력 기간. 일자를 더해준다
			for(int j = 0; j<time[0][i]-1; j++) period+=monthday[j];//월 단위 환산
			for(int k = period; k<Math.min(period+30,366); k++) {
				year[k]+=money[i];
			}
		}
		for(int i = 1; i<=365; i++) {
			if(year[i]>=100000) dia++;
			else if(year[i]>=50000) plantinum++;
			else if(year[i]>=20000)gold++; 
			else if(year[i]>=10000)silver++;
			else bronze++;
		}
		int[] answer = {bronze,silver,gold,plantinum,dia};
		return answer;
	}
}