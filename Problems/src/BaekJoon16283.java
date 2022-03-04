import java.io.*;
import java.util.*;

public class BaekJoon16283 {
	public static int a,b,n,w,count,x,y,flag;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		for(int i = 1; i<n; i++) { //i가 n보다 커지면 나머지 한 동물의 수는 0이하가 되므로 i<n
			if(a*i+b*(n-i)==w) { //조건 만족
				count++; // 해의 개수 카운트
				x=i; 
				y=n-i;
				//그때의 해 값 저장
			}
			if(count==2)break; //시간 단축을 위해 해가 여러 개일시 탈출
		}
		if(count==0||count>=2)System.out.println(-1); // 해가 없거나 2개이상일 경우
		else { //출력. 단, x+" "+y형식으로 할시 문자열 변환으로 인해 시간초과가 날 수도 있다..
			System.out.print(x); 
			System.out.print(" ");
			System.out.print(y);
		}
	}
}
