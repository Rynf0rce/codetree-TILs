import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 500000;
    public static final int[] MOD = new int[]{(int) 1e9 + 7, (int) 1e9 + 9};
    public static final int[] P = new int[]{31, 37};
    public static long[][] pPow = new long[2][MAX_LENGTH + 1];
    public static long[] inHash = new long[2];
    public static long[] targetHash = new long[2];
    public static int[] exists = new int[2];

    public static int toInt(char c){
        return c - 'a' + 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inStr = String.valueOf(br.readLine());
        String targetStr = String.valueOf(br.readLine());

        for(int k = 0 ; k < 2 ; k++){
            pPow[k][0] = 1;
            exists[k] = -1;
            for(int i = 1 ; i <= inStr.length() ; i++){
                pPow[k][i] = pPow[k][i - 1] * P[k] % MOD[k];
            }

            // 초기값 정의
            for(int i = 0 ; i < targetStr.length() ; i++){
                inHash[k] = inHash[k] + toInt(inStr.charAt(i)) * pPow[k][targetStr.length() - 1 - i] % MOD[k];
                targetHash[k] = targetHash[k] + toInt(targetStr.charAt(i)) * pPow[k][targetStr.length() - 1 - i] % MOD[k]; 
            }

            if(inHash[k] == targetHash[k]){
                exists[k] = 0;
                continue;
            }

            for(int i = 1 ; i <= inStr.length() - targetStr.length() ; i++){
                inHash[k] = (inHash[k] * P[k] - toInt(inStr.charAt(i - 1)) * pPow[k][targetStr.length()] + toInt(inStr.charAt(i + targetStr.length() - 1))) % MOD[k];
                if(inHash[k] < 0){
                    inHash[k] += MOD[k];
                }

                if(inHash[k] == targetHash[k]){
                    exists[k] = i;
                    break;
                }
            }
        }

        if(exists[0] >= 0 && exists[1] >= 0){
            System.out.print(Math.min(exists[0], exists[1]));
        }
        else{
            System.out.print(-1);
        }
    }
}