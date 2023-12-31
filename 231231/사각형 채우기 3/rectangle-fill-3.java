import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
    public static final int MAX_RANGE = 1000;
    public static final BigInteger MOD = BigInteger.valueOf(1000000007);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger[] arr = new BigInteger[MAX_RANGE + 1];
        int n = sc.nextInt();
        arr[0] = BigInteger.valueOf(1);
        arr[1] = BigInteger.valueOf(2);
        arr[2] = BigInteger.valueOf(7);
        BigInteger three = BigInteger.valueOf(3);
        for(int i = 3 ; i <= n ; i++){
            BigInteger temp = arr[i - 1].multiply(three);
            temp = temp.add(arr[i-2]);
            temp = temp.subtract(arr[i-3]);
            arr[i] = temp ;
        }

        System.out.print(arr[n].remainder(MOD).toString());
    }
}