package Gold;

import java.io.*;
import java.util.*;

public class BaekJoon5577 {
	public static void main(String[] args) throws IOException{
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N;i++) { //각 지점 
			for(int j= 1; j <4;j++) {
				int deletedBall = gogo(arr,i,N,j);
				if(max <deletedBall) {
					max = deletedBall;
				}

			}
		}
		System.out.println(N-max);
		
	}

	public static int gogo(int[] arr, int i, int N, int value) {//지워지는 공 수 반환
		int left =i-1;//앞
		int right = i+1;//뒤
		int deletedBall= 0;//지워지는 공 수
		int count = 1; //반복되는 같은 색 공
		
		while(true) {
			while( left >= 0 && arr[left] == value ) {
				count++;
				left--;
			}
			while(right < N &&arr[right] ==value) {
				count++;
				right++;
			}
			
			if(count<4) {
				break;
			}
			deletedBall+= count;
			count = 0;
			if(left>=0) {
				value = arr[left];
			}
			if(right < N) {
				value = arr[right];
			}
		}
		
		return deletedBall;
	}
}
