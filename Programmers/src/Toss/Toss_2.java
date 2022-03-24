package Toss;
import java.io.*;
import java.util.*;
public class Toss_2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int[] a = {1,50};
		int[] b = {51,100};
		int duration =100;
		int distance =100;
		int flag = 0;
		int[] promisedis = new int[101]; //약속장소별 시간
		Arrays.fill(promisedis, Integer.MAX_VALUE); //최소값 검출을 위한 안배
		for(int i =0; i<=100; i++) {
			int promise = 0; //약속시간
			int lasttime = 0; // 최종시간
			int timeA = i;
			int timeB = Math.abs(distance-i);
			if(a[0]+timeA>=b[0]+timeB) promise = a[0]+timeA;
			else promise = b[0]+timeB;			
			lasttime = promise+duration;
			if(lasttime+timeA>a[1]||lasttime+timeB>b[1]) {
				promisedis[i] = Integer.MAX_VALUE;
				flag=1;
			}
			else promisedis[i] = promise;			
		}
		Arrays.sort(promisedis);
		if(flag==1&&promisedis[0]==Integer.MAX_VALUE)System.out.println(-1);
		else System.out.println(promisedis[0]);
	}

}
