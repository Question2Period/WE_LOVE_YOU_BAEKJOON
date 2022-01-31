import java.io.*;
import java.util.*;

public class BaekJoon2875 { //대회 or 인턴(브론즈 3)

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i = 0; i < K; i++) { // 인턴쉽 인원수 만큼 반복하며 뺴준다.
			if(N>=2*M) {  //여학생이 남학생의 2배이상이면 여학생을 인턴쉽에 참여시킨다.
				N--;
			}
			else {//남학생의 2배가 더 많다면 남학생이 인턴쉽에 참여한다.
				M--;
			}
		}
		if(N<=2*M) {
		System.out.println(N/2); //현재 여학생 수/2를 출력한다.
	}
		else
			System.out.println(M);
	}

}
