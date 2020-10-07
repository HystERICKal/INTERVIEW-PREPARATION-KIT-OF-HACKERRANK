package hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Flipping_Bits {

    static long flippingBits(long n) {
        String q = "";
        while(n!=0)
        {
            q = (n%2)+q;
            n = n/2;
        }
        
        long len = q.length();
        for(int i=0;i<(32-len);i++)
        {
            q = "0"+q;
        }
        String rev = "";
        for(int i=0;i<32;i++)
        {
            if(q.charAt(i)=='1')
            {
                rev = rev+'0';
            }
            else
            {
                rev = rev+'1';
            }
        }
        double x = 0;
        int p = 0;
        for(int i=rev.length()-1;i>=0;i--)
        {
            if(rev.charAt(i)=='1')
            {
                x = x+Math.pow(2,p);
            }
            p++;
        }
        return ((long)x);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
