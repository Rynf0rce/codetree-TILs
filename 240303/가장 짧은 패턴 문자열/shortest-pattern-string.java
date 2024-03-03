import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] f = new int[MAX_LENGTH  +1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = String.valueOf(br.readLine());
        int strLength = str.length();
        str = "#" + str;

        f[0] = -1;
        for(int i = 1 ; i <= strLength ; i++){
            int j = f[i - 1];
            while(j >= 0 && str.charAt(j + 1) != str.charAt(i)){
                j = f[j];
            }

            f[i] = j + 1;
        }

        System.out.print(strLength - f[strLength]);
    }
}