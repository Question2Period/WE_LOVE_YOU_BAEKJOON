package Bronze;
import java.io.*;
public class BaekJoon10551 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] arr = new int[8];
		for(int i = 0; i<str.length(); i++) {
			switch(str.charAt(i)) {
			case '1' : arr[0]++; break;
			case 'Q' : arr[0]++; break;
			case 'A' : arr[0]++; break;
			case 'Z' : arr[0]++; break;
			case '2' : arr[1]++; break;
			case 'W' : arr[1]++; break;
			case 'S' : arr[1]++; break;
			case 'X' : arr[1]++; break;
			case '3' : arr[2]++; break;
			case 'E' : arr[2]++; break;
			case 'D' : arr[2]++; break;
			case 'C' : arr[2]++; break;
			case '4' : arr[3]++; break;
			case 'R' : arr[3]++; break;
			case 'F' : arr[3]++; break;
			case 'V' : arr[3]++; break;
			case '5' : arr[3]++; break;
			case 'T' : arr[3]++; break;
			case 'G' : arr[3]++; break;
			case 'B' : arr[3]++; break;
			case '6' : arr[4]++; break;
			case 'Y' : arr[4]++; break;
			case 'H' : arr[4]++; break;
			case 'N' : arr[4]++; break;
			case '7' : arr[4]++; break;
			case 'U' : arr[4]++; break;
			case 'J' : arr[4]++; break;
			case 'M' : arr[4]++; break;
			case '8' : arr[5]++; break;
			case 'I' : arr[5]++; break;
			case 'K' : arr[5]++; break;
			case ',' : arr[5]++; break;
			case '9' : arr[6]++; break;
			case 'O' : arr[6]++; break;
			case 'L' : arr[6]++; break;
			case '.' : arr[6]++; break;
			case '0' : arr[7]++; break;
			case 'P' : arr[7]++; break;
			case ';' : arr[7]++; break;
			case '/' : arr[7]++; break;
			case '-' : arr[7]++; break;
			case '[' : arr[7]++; break;
			case 39 : arr[7]++; break;
			case '=' : arr[7]++; break;
			case ']' : arr[7]++; break;
			
			}
		}
		for(int j = 0; j<8; j++) {
			System.out.println(arr[j]);
		}
	}

}
