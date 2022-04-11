package Beginner;
import java.io.*;
import java.util.*;
public class C410{
 
  public static void main(String[] args) throws IOException{
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    String[] arr = new String[17];
    int N = Integer.parseInt(br.readLine());
    arr[1] = "1";
    arr[2] = "1 2 1";
    for(int i = 3; i<=16; i++) {
    	arr[i] = arr[i-1] + " "+i+" "+arr[i-1];
    }
    System.out.println(arr[N]);
  }
}