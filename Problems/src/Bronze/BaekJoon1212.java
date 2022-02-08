package Bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--){
            int num = str.charAt(i) - '0';
            if(str.length() == 1 && num == 0){
                sb.append(0);
                break;
            } 
            int cnt = 0;
            while(num > 0){
                cnt++;
                sb.append(num % 2);
                num /= 2;
            }

            if(i == 0) break; 
            for(int j = 0; j<(Math.max(0, 3 - cnt)); j++) {
            sb.append("0"); } 

        }
        System.out.println(sb.reverse().toString());
    }
}



