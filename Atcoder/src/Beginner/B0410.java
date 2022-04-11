package Beginner;
import java.io.*;
import java.util.*;
public class B0410{
 
  public static void main(String[] args) throws IOException{
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    String[][] arr = new String[T][2];
    for(int i = 0; i<T; i++){
    st = new StringTokenizer(br.readLine());
      arr[i][0] = st.nextToken(); //성
      arr[i][1] = st.nextToken(); //이름
    }
    int flag = 0;
   outer : for(int i = 0; i<T; i++){ 	
    	for(int j = 0; j<2; j++){
          String ty = arr[i][j];
        	mid : for(int k = 0; k<T;k++){
            	for(int w = 0; w<2; w++){
                if(k==i)continue;
                  if(ty.equals(arr[k][w])){//다른 겹치는 이름이 존재
                    flag = -1;
                    break mid;
                  }
                  else flag=0;
                }
            }
        }
    	 if(flag==-1) {
          	  System.out.println("No");
          	  break outer;
            }
    }
    if(flag==0)System.out.println("Yes");
  }
}