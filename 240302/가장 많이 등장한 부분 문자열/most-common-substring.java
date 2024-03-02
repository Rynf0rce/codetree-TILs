import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int MOD = (int) 1e9 + 9;
    public static final int P = 37;
    public static long[] pPow = new long[MAX_LENGTH + 1];

    public static TreeMap<Long, Integer> ansMap = new TreeMap<>();

    public static int toInt(char c){
        return c - 'a' + 1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = 1;
        int n = Integer.parseInt(st.nextToken());
        String str = String.valueOf(st.nextToken());

        pPow[0] = 1;
        for(int i = 1 ; i <= str.length() ; i++){
            pPow[i] = (pPow[i - 1] * P) % MOD;
        }

        long hashVal = 0;

        for(int i = 0 ; i < n ; i++){
            hashVal = (hashVal + str.charAt(i) * pPow[n - i - 1]) % MOD;
        }

        ansMap.put(hashVal, 1);

        for(int i = 1 ; i <= str.length() - n ; i++){
            hashVal = (hashVal * P - str.charAt(i - 1) * pPow[n] + str.charAt(n + i - 1)) % MOD;
            ansMap.put(hashVal, ansMap.getOrDefault(hashVal, 0) + 1);
            ans = Math.max(ansMap.get(hashVal), ans);
        }

        System.out.print(ans);
    }
}