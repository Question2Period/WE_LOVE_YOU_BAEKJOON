package Beginner;
import java.io.*;
import java.util.*;
public class A0410{
	
  public static void main(String[] args) throws IOException{
  
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  	StringBuilder sb = new StringBuilder();
    String str = br.readLine();
    sb.append(0);
    for(int i = 0; i<3; i++){
    	sb.append(str.charAt(i));
    }
    System.out.println(sb);
  }
}