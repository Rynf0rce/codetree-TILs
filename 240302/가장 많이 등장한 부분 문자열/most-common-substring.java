import java.util.*;
import java.io.*;

class Tuple{
    private long x;
    private long y;

    public Tuple(long x, long y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return x == tuple.x && y == tuple.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }
}

public class Main {
    public static final int MAX_LENGTH = 100000;
    public static final int[] MOD = new int[]{(int) 1e9 + 7, (int) 1e9 + 9};
    public static final int[] P = new int[]{31, 37};
    public static long[][] pPow = new long[2][MAX_LENGTH + 1];

    public static HashMap<Tuple, Integer> ansMap = new HashMap<>();

    public static int toInt(char c){
        return c - 'a' + 1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = 1;
        int n = Integer.parseInt(st.nextToken());
        String str = String.valueOf(st.nextToken());

        for(int k = 0 ; k < 2 ; k++){
            pPow[k][0] = 1;
            for(int i = 1 ; i <= str.length() ; i++){
                pPow[k][i] = (pPow[k][i - 1] * P[k]) % MOD[k];
            }
        }

        long[] hashVal = new long[]{0, 0};

        for(int k = 0 ; k < 2 ; k++){
            for(int i = 0 ; i < n ; i++){
                hashVal[k] = (hashVal[k] + str.charAt(i) * pPow[k][n - i - 1]) % MOD[k];
            }
        }

        ansMap.put(new Tuple(hashVal[0], hashVal[1]), 1); 

        for(int i = 1 ; i <= str.length() - n ; i++){
            for(int k = 0 ; k < 2 ; k++){
                hashVal[k] = (hashVal[k] * P[k] - str.charAt(i - 1) * pPow[k][n] + str.charAt(n + i - 1)) % MOD[k];

                if(hashVal[k] < 0){
                    hashVal[k] += MOD[k];
                }
            }

            Tuple curTuple = new Tuple(hashVal[0], hashVal[1]);

            ansMap.put(curTuple, ansMap.getOrDefault(curTuple, 0) + 1);
            ans = Math.max(ansMap.get(curTuple), ans);
        }

        System.out.print(ans);
    }
}