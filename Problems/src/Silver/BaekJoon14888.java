package Silver;
import java.io.*;
import java.util.*;
public class BaekJoon14888 {
	public static int[] input,calcu,choice;
	public static boolean[] visit;
	public static int max,min,N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		input = new int[N];//입력 수
		calcu = new int[N-1];//연산자 담기. 백트래킹 대상
		choice = new int[N-1];//연산자 담기. 백트래킹 대상
		visit = new boolean[N-1];//연산자 담기. 백트래킹 대상
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N; i++)input[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());//+
		int num2 = Integer.parseInt(st.nextToken());//-
		int num3 = Integer.parseInt(st.nextToken());//*
		int num4 = Integer.parseInt(st.nextToken());// 나누기
		for(int i = 0; i<N-1; i++) {
			if(num1!=0) {
				calcu[i] = '+';
				num1--;
			}
			else if(num2!=0) {
				calcu[i] = '-';
				num2--;
			}
			else if(num3!=0) {
				calcu[i] = '*';
				num3--;
			}
			else if(num4!=0) {
				calcu[i] = '/';
				num4--;
			}
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		comb(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void comb(int cur) {
		if(cur==N-1) {
			int result = sum();
			max= Math.max(max, result);
			min= Math.min(min, result);
		}
		
		for(int i =0; i<N-1; i++) {
			if(visit[i])continue;
			visit[i] = true;
			choice[cur] = calcu[i];
			comb(cur+1);
			visit[i] = false;
		}
	}
	
	public static int sum() {
		int s = input[0];
		for(int i = 0; i<N-1; i++) {
			switch (choice[i]) {
			case '+' :
				s+=input[i+1];
				break;
			case '-' :
				s-=input[i+1];
				break;
			case '*' :
				s*=input[i+1];
				break;
			case '/' :
				s/=input[i+1];
				break;
			}
		}
		return s;
	}

}
