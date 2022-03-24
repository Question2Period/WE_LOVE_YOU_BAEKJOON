package Toss;
import java.io.*;
import java.util.*;
public class Toss_1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int k = 2;
		int m = 3451;
		String[] names = {"abcd", "aBCd", "jsKIM", "rrr", "rrr"};
		int[] amounts = {950, 1000, 1400, 4000, 10000};
		
		int answer = 0;
		int cnt = 0; //반복된 횟수 세기
		String before ="";
		for(int i = 0; i<names.length; i++) {
			String str = names[i];
			int money = amounts[i];
			str = str.toUpperCase(); //대소구분 없으므로 모두 대문자 전환
			if(before.equals(str))cnt++;
			else cnt =1;
			if(cnt>=k || money>=m)answer++;
			before=str;
		}
		System.out.println(answer);
		
	}

}
