package Midas;
import java.util.*;
public class skt1 {
	public static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int money = 4578;
		int[] costs ={1, 4, 99, 35, 50, 1000};
		arr = new int[6][3];
		arr[0][0] = 1;
		arr[1][0] = 5;
		arr[2][0] = 10;
		arr[3][0] = 50;
		arr[4][0] = 100;
		arr[5][0] = 500;
		for(int i = 0; i<6; i++) {
			arr[i][1] = costs[i]; //제작비용
			arr[i][2] = costs[i]*(500/arr[i][0]); // 같은값 만들때 드는 비용 비교용
		}
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
		for(int i = 0; i<6; i++) {
			int coin = money/arr[i][0]; //최대 동전 개수
			money%=arr[i][0]; // 동전 사용후 남는 돈
			sum+=(coin*arr[i][1]);
			if(money==0)break;
		}
		System.out.println(sum);
	}

}
