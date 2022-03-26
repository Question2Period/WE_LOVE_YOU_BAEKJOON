package Beginner;
import java.io.*;
import java.util.*;
public class B_20220326{
  public static void main(String [] args) throws IOException{
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N= Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
    Arrays.sort(arr);
    int cnt = 0;

    while(true) {
    	if(Arrays.binarySearch(arr, cnt)<0) {
    		System.out.println(cnt);
    		break;
    	}
    	else cnt++;   	
    }
  }
}
