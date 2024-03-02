import java.util.*;
import java.io.*;

class Tuple{
    private long a, b;
    public Tuple(long a, long b){
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return tuple.a == this.a && tuple.b == this.b;
    }

    @Override
    public int hashCode(){
        return Objects.hash(a, b);
    }
}

public class Main {
    public static final int MAX_LENGTH = 5000;
    public static int[] P = new int[]{31, 37};
    public static int[] MOD = new int[]{(int)1e9 + 7, (int)1e9 + 9};
    public static long[][] pPow = new long[2][MAX_LENGTH + 1];
    public static HashMap<Tuple, Integer> ansMap = new HashMap<>();
    public static String str = " ";

    public static int toInt(char c){
        return c - 'a' + 1;
    }

    public static int hashing(int length){
        ansMap.clear();
        long[] h = new long[2];
        
        for(int k = 0 ; k < 2 ; k++){
            for(int i = 0 ; i < length ; i++){
                h[k] = (h[k] + toInt(str.charAt(i)) * pPow[k][length - 1 - i]) % MOD[k];
            }
        }

        Tuple startTuple = new Tuple(h[0], h[1]);
        ansMap.put(startTuple, ansMap.getOrDefault(startTuple, 0) + 1);

        for(int i = 1 ; i <= str.length() - length ; i++){
            for(int k = 0 ; k < 2 ; k++){
                h[k] = (h[k] * P[k] - toInt(str.charAt(i - 1)) * pPow[k][length] + toInt(str.charAt(i + length - 1))) % MOD[k];
                if(h[k] < 0){
                    h[k] += MOD[k];
                }
            }
            Tuple inTuple = new Tuple(h[0], h[1]);
            ansMap.put(inTuple, ansMap.getOrDefault(inTuple, 0) + 1);
        }

        return ansMap.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = String.valueOf(br.readLine());

        for(int k = 0 ; k < 2 ; k++){
            pPow[k][0] = 1;
            for(int i = 1 ; i <= str.length() ; i++){
                pPow[k][i] = (pPow[k][i - 1] * P[k]) % MOD[k];
            }
        }

        int ans = 0;
        for(int i = 1 ; i <= str.length() ; i++){
            ans += hashing(i);
        }
        
        System.out.print(ans);
    }
}