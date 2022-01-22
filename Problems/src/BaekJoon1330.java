import java.io.*;
import java.util.*;

public class BaekJoon1330 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] arr = input.split(" "); // 공백 구분. 하지만 사실 StringTokenizer로 찢으면 된다(...)
		if(Integer.parseInt(arr[0])>Integer.parseInt(arr[1])) {//arr안의 값은 문자열이므로 int로 변환!
			System.out.println('>');
		}
		else if(Integer.parseInt(arr[0])<Integer.parseInt(arr[1])) {
			System.out.println('<');
		}
		else {
			System.out.println("==");
		}
	}

}
