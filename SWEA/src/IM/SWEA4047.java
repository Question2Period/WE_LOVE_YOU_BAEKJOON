package IM;
import java.io.*;
import java.util.*;
public class SWEA4047 {
	public static int flag;
	public static Set<Integer> CountS;
	public static Set<Integer> CountD;
	public static Set<Integer> CountH;
	public static Set<Integer> CountC;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str;
		int number = 0;
		for(int t =1; t<=T; t++) {
			CountS = new HashSet<>(); // 스페이드 카드 담기
			CountD = new HashSet<>(); // 다이아 카드 담기
			CountH = new HashSet<>(); // 하트 카드 담기
			CountC = new HashSet<>(); // 클로버 카드 담기
			str = br.readLine(); //문자열
			number = str.length()/3; // 카드의 개수
			flag=0;
			if(str.length()>156)System.out.println("#"+t+" ERROR");
			else
			for(int i = 0; i<str.length()-2; i+=3) {
				char kind = str.charAt(i); //카드의 종류
				int Label = (str.charAt(i+1)-'0')*10+str.charAt(i+2)-'0'; //카드 번호
				switch (kind) {
				case 'S':
					if(CountS.contains(Label))flag=1;
					CountS.add(Label); //S 셋에 카드 담기
					
					break;
				case 'D': 
					if(CountD.contains(Label))flag=1;
					CountD.add(Label);//D 셋에 카드 담기
				
				break;
				case 'H': 
					if(CountH.contains(Label))flag=1;
					CountH.add(Label);//H 셋에 카드 담기
				
				break;
				case 'C': 
					if(CountH.contains(Label))flag=1;
					CountC.add(Label);//C 셋에 카드 담기
				
				break;

				}
				if(flag==1)System.out.println("#"+t+" ERROR");// 중복된 카드가 있다면 수가 일치하지 않으므로 에러 출력
			}
			int S = 13-CountS.size();//모자란 스페이드 카드 개수
			int D = 13-CountD.size();//모자란 다이아 카드 개수
			int H = 13-CountH.size();//모자란 하트 카드 개수
			int C = 13-CountC.size();//모자란 클로버 카드 개수
			if(flag==0)System.out.println("#"+t+" "+S+" "+D+" "+H+" "+C+" ");//아니라면 부족한 카드 수 출력
		}
	}

}
