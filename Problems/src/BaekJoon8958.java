import java.io.*;
public class BaekJoon8958 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int Score = 0;
		int Sum = 0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='O') {
					Sum+=1+Score;
					if(j!=str.length()-1) {
					if(str.charAt(j+1)=='O') {	
						Score++;					
				}
					else if(str.charAt(j+1)=='X')
					{					
						Score = 0;					
					}
			}
				}
				else {
					continue;
				}
			}
			System.out.println(Sum);
			Sum=0;
			Score=0;
		}
	}
}