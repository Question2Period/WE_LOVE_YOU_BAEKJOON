package Beginner;
import java.io.*;
import java.util.*;

public class A_20220226 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i = 0; i<10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int first = arr[0];
		int second = arr[first];
		int third = arr[second];
		System.out.println(third);
		
	}

}
