import java.io.*;
public class ICPC2022_A {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int count;
		int max = Integer.MIN_VALUE;
		int C = Integer.parseInt(br.readLine());
		for(int i = 0; i<C; i++) {
			str = br.readLine();
			count = 0;
			for(int j = 0; j<=str.length()-3;j++) {
				if(j<=str.length()-3) {
					if(j<=str.length()-5) {
						if(str.charAt(j)=='w'&&str.charAt(j+1)=='h'&&str.charAt(j+2)=='i'
								&&str.charAt(j+3)=='l'&&str.charAt(j+4)=='e') {
							j+=4;
							count++;
								continue;
								}
					}
					if(str.charAt(j)=='f'&&str.charAt(j+1)=='o'&&str.charAt(j+2)=='r') {
						j+=2;
						count++;
						}
				}
			}
			max=Math.max(max, count);
		}
		System.out.println(max);
	}

}
