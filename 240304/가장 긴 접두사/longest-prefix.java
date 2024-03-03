import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] f = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = String.valueOf(br.readLine());
        int strLength = str.length();
        // str = "#" + str;
        
        f[0] = -1;
        int j = 0;
        int ans = 0;
        for(int i = strLength - 1 ; i >= 0 ; i--){
            if(str.charAt(j) == str.charAt(i)){
                j++;
            }
            else{
                ans = Math.max(ans, j);
                j = 0;
            }
        }

        ans = Math.max(ans, j);

        System.out.println(ans);
    }
}