package Gold;
import java.util.*;
import java.io.*;

public class BaekJoon9663 {

	static int[] queen;
	static int n;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		queen = new int[n]; // 퀸을 배치할 행의 번호를 1~N번까지 사용 예정
		backtrack(0);
		System.out.println(ans);
	}

	static void backtrack(int row) {
		if (row == n) {
			ans++;
			return;
		}
		for (int j = 0; j < n; j++) {
			queen[row] = j;
			if (isOk(row)) { 
				backtrack(row + 1);
			} 
		}
	}

	static boolean isOk(int col) {
		// 지금 row행에 놓은 퀸이 이전 퀸들에 영향을 안받는 자리에 있는지 확인
		for (int i = 0; i < col; i++) {
			// 현재 row 위치에 퀸이 있음
			if (queen[col] == queen[i])
				return false;
			//대각선
			if (Math.abs(col - i) == Math.abs(queen[i] - queen[col])) {
				return false;
			}
		}
		return true;
	}

}