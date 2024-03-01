import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 500000;
       
    public static int n, l;
    
    // 2개의 polynomial rolling 해싱을 위한 p, m 값을 정의합니다.
    public static int[] p = new int[]{31, 37};
    public static int[] m = new int[]{(int)1e9 + 7, (int)1e9 + 9};
    
    // p^i, 값을 m으로 나눈 나머지를 관리합니다.
    public static long[][] pPow = new long[2][MAX_N + 1];
    
    // 소문자 알파벳을 수로 변경합니다.
    public static int toInt(char c) {
        return c - 'a' + 1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = MAX_N;
        String T = String.valueOf(br.readLine());
        String P = String.valueOf(br.readLine());
        n = T.length();
        l = P.length();

        // pPow 값을 계산합니다.
        for(int k = 0; k < 2; k++) {
            // pPow[i] = p^i % m
            pPow[k][0] = 1;
            for(int i = 1; i <= n; i++)
                pPow[k][i] = (pPow[k][i - 1] * p[k]) % m[k];
        }

        // pattern에 대한 해싱값인 pH값을 계산합니다.
        // pH = (P[0] * p^(l - 1) + P[1] * p^(l - 2) + ... + P[l - 1] * 1) % m
        // 소문자 알파벳은 a부터 z까지 순서대로 1부터 26까지의 수와 대응됩니다.
        long[] pH = new long[2];
        for(int k = 0; k < 2; k++) {
            for(int i = 0; i < l; i++)
                pH[k] = (pH[k] + toInt(P.charAt(i)) * pPow[k][l - 1 - i]) % m[k];
        }
        
        // text에서 구간 [0, l - 1]에 해당하는 해싱값을 계산합니다.
        long[] tH = new long[2];
        for(int k = 0; k < 2; k++) {
            for(int i = 0; i < l; i++)
                tH[k] = (tH[k] + toInt(T.charAt(i)) * pPow[k][l - 1 - i]) % m[k];
        }

        boolean exists = false;
        // 이미 일치한다면 존재하는 것입니다.
        if(pH[0] == tH[0] && pH[1] == tH[1]){
            ans = 0;
            exists = true;
        }
            

        // text에서
        // 길이가 l인 부분문자열을 전부 잡아봅니다.
        for(int i = 1; i <= n - l; i++) {
            for(int k = 0; k < 2; k++) {
                // 이전 [i - 1, i + l - 2]에 해당하는 해싱값은 tH에 있습니다.
                // 이전 값(tH)은 (T[i - 1] * p^(l - 1) + T[i] * p^(l - 2) + ... + T[i + l - 2] * 1) % m입니다.
                // 이제 tH * p - T[i - 1] * p^l + T[i + l - 1]를 계산하면
                // 새로 계산을 원하는 해싱값인 (T[i] * p^(l - 1) + T[i + 1] * p(l - 2) + ... + T[i + l - 1] * 1) % m이 됩니다.
                tH[k] = (tH[k] * p[k] - toInt(T.charAt(i - 1)) * pPow[k][l] + toInt(T.charAt(i + l - 1))) % m[k];
                // tH값을 양수로 변환해줍니다.
                if(tH[k] < 0)
                    tH[k] += m[k];
            }

            // 값이 일치한다면 존재하는 것입니다.
            if(pH[0] == tH[0] && pH[1] == tH[1]){
                ans = i;
                exists = true;
                break;
            }
        }

        if(exists){
            System.out.print(ans);
        }
        else{
            System.out.print(-1);
        }
    }
}