import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 500000;
    public static final int[] MOD = new int[]{(int)1e9 + 7, (int)1e9 + 9};
    public static final int[] P = new int[]{31, 37};
    public static long[][] pPow = new long[2][MAX_LENGTH + 1];
    public static long[] hashIn = new long[2];
    public static long[] hashCp = new long[2];

    public static int toInt(char c){
        return c - 'a' + 1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inStr = String.valueOf(br.readLine());
        String cpStr = String.valueOf(br.readLine());
        int inLength = inStr.length();
        int cpLength = cpStr.length();
        boolean exist = false;
        int ans = MAX_LENGTH + 1;

        for(int k = 0 ; k < 2 ; k++){
            pPow[k][0] = 1;
            for(int i = 1 ; i <= inLength ; i++){
                pPow[k][i] = (pPow[k][i - 1] * P[k]) % MOD[k];
            }
        }

        for(int k = 0 ; k < 2 ; k++){
            for(int i = 0 ; i < cpLength ; i++){
                hashCp[k] = (hashCp[k] + toInt(cpStr.charAt(i)) * pPow[k][cpLength - i - 1]) % MOD[k];
                hashIn[k] = (hashIn[k] + toInt(inStr.charAt(i)) * pPow[k][cpLength - i - 1]) % MOD[k];
            }
        }

        if(hashCp[0] == hashIn[0] && hashCp[1] == hashIn[1]){
            ans = 0;
            exist = true;
        }

        for(int i = 1 ; i <= inLength - cpLength ; i++){
            for(int k = 0 ; k < 2 ; k++){
                hashIn[k] = ( (hashIn[k] * P[k] % pPow[k][cpLength]) + toInt(inStr.charAt(i + cpLength - 1))) % MOD[k];

                if(hashIn[k] < 0){
                    hashIn[k] += MOD[k];
                }
            }

            if(hashCp[0] == hashIn[0] && hashCp[1] == hashIn[1]){
                ans = i;
                exist = true;
                break;
            }
        }

        if(exist){
            System.out.print(ans);
        }
        else{
            System.out.print(-1);
        }


        
    }
}