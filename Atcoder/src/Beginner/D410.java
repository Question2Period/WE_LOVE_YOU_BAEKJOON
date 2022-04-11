package Beginner;
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class D410{
 
  public static void main(String[] args) throws IOException{
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    Queue<Integer>Q =new LinkedList<>();
    int T = Integer.parseInt(br.readLine());
    for(int t = 0; t<T; t++) {
    	st = new StringTokenizer(br.readLine());
    	int task = Integer.parseInt(st.nextToken());
    	if(task==1) {//큐에 넣기
    		int num = Integer.parseInt(st.nextToken());
    		int time = Integer.parseInt(st.nextToken());
    		for(int i = 0; i<time; i++) {
    			Q.offer(num);
    		}
    	}
    	
    	else {
    		BigInteger sum = new BigInteger("0");
    		int time = Integer.parseInt(st.nextToken());
    		for(int i =0; i<time; i++) {
    			BigInteger big = BigInteger.valueOf(Q.poll());
    			sum = sum.add(big);
  
    			
    		}
    		System.out.println(sum);
    	}
    	
    }
  }
}