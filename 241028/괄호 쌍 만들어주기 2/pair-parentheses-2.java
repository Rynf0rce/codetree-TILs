import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100;
    public static int[] left = new int[100 + 1];
    public static int[] right = new int[100 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = " "+ br.readLine();
        for(int i = 1 ; i <= str.length() - 2 ; i++){
            left[i] += left[i - 1];

            if(str.charAt(i) == ')'){
                continue;
            }

            if(str.charAt(i) == str.charAt(i - 1)){
                left[i]++;
            }
        }

        int ans = 0;
        for(int j = str.length() - 2 ; j >= 1 ; j--){
            if(str.charAt(j) == '('){
                continue;
            }

            if(str.charAt(j) == str.charAt(j + 1)){
                ans += left[j - 1];
            }
        }
        System.out.print(ans);
    }
}