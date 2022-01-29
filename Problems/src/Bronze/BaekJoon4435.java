package Bronze;

import java.util.Scanner;

public class BaekJoon4435 {
    static int testCase;
    final static int gandalfu[] = { 1, 2, 3, 3, 4, 10 };
    final static int sauron[] = { 1, 2, 2, 2, 3, 5, 10 };
    static int result[];
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);

        testCase = Integer.parseInt(scan.nextLine().trim());
        result = new int[testCase];
        
        for (int i = 0; i < testCase; i++) {
            long unit;
            long gandalfuForce = 0;
            long sauronForce = 0;
            
            for(int j = 0; j < gandalfu.length; j++) {
                unit = scan.nextLong();
                gandalfuForce += (gandalfu[j] * unit);
            }
            
            for(int j = 0; j < sauron.length; j++) {
                unit = scan.nextLong();
                sauronForce += (sauron[j] * unit);
            }
            
            if(gandalfuForce == sauronForce)
                result[i] = 0;
            else if(gandalfuForce > sauronForce)
                result[i] = 1;
            else
                result[i] = 2;
        }
        
        
        for(int i = 0; i <testCase; i++) {
            System.out.print("Battle " + (i+1) + ": " );
            if(result[i] == 0)
                System.out.println("No victor on this battle field");
            else if(result[i] == 1)
                System.out.println("Good triumphs over Evil");
            else
                System.out.println("Evil eradicates all trace of Good");
        }
        
    }
}
