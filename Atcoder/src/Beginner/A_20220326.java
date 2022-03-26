package Beginner;
import java.io.*;
import java.util.*;
public class A_20220326{
  public static void main(String [] args) throws IOException{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());
    int Takahashi = 3600*A+60*B;
    int Aoki = 3600*C+60*D+1;
    if(Takahashi<Aoki)System.out.println("Takahashi");
    else System.out.println("Aoki");
    
    
    
  }
}
