import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static int[] f = new int[MAX_LENGTH + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = String.valueOf(br.readLine());
        String P = String.valueOf(br.readLine());

        int n = T.length();
        int m = P.length();

        T = "#" + T;
        P = "#" + P;

        f[0] = -1;
        for(int i = 1; i <= m ; i++){
            int j = f[i - 1];
            
            while(j >= 0 && P.charAt(j + 1) != P.charAt(i)){
                j = f[j];
            }

            f[i] = j + 1;
        }

        int j = 0;
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            while(j >= 0 && P.charAt(j + 1) != T.charAt(i) ){
                j = f[j];
            }
            j++;
            if(j == m){
                ans++;
                j = f[j];
            }
        }
        System.out.print(ans);
    }
}