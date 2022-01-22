import java.io.*;
public class BaekJoon9498 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Score = Integer.parseInt(br.readLine());
		if(Score>=90) {
			System.out.println('A');
		}
		else if(Score>=80) {
			System.out.println('B');
		}
		else if(Score>=70) {
			System.out.println('C');
		}
		else if(Score>=60) {
			System.out.println('D');
		}
		else {
			System.out.println('F');
		}
	}

}
