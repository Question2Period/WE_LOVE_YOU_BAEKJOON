package Gold;
import java.io.*;
import java.util.*;
public class BaekJoon7806 {
	public static int n,k,YaksuK,YaksuN,x,answer;

	public static void main(String[] args) throws IOException{ //EOF + 소인수분해 + 유클리드..
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		while((str=br.readLine())!=null) { //입력이 없으면 종료
			st = new StringTokenizer(str); 
			n = Integer.parseInt(st.nextToken()); //n
			k = Integer.parseInt(st.nextToken()); //k
			answer=1; //최대공약수
			int a = k; // 소인수분해 마루타
			if(n>=k)answer=k;
			else 
				for(int i =2; i*i<=k; i++) { // 소인수분해
					YaksuK=0;
					YaksuN=0;
					while(a%i==0) { //안나눠질때까지 모듈러
						a/=i;
						YaksuK++; // i의 제곱횟수
					}
					if(YaksuK==0)continue; //i가 k의 소인수가 아니므로 다음 수 진행
					x=i; // 팩토리얼 마루타
					while(x<=n) { // x가 n보다 커지면 모듈러값 0이므로 탈출
						YaksuN+=n/x; // i의 개수
						x*=i; // i, i*i, i*i*i ... 연산해준다
					}
					answer*=Math.pow(i, Math.min(YaksuK, YaksuN)); //둘 중 작은 녀석이 최대 공약수의 소인수이다
				}
			//			sb.append(answer).append("\n");
			if(a!=1 && a<=n&&n<k) answer*=a;

			System.out.println(answer); //출력
		}

		//		System.out.println(sb);
	}
}