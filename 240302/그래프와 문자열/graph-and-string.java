import java.util.*;
import java.io.*;

class node{
    int idx, weight;
    public node(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }
}



public class Main {
    public static final int MAX_NODE = 100000;
    public static final int[] MOD = new int[]{(int)1e9 + 7, (int)1e9 + 9};
    public static final int[] P = new int[]{31, 37};
    public static ArrayList<node>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static long[][] pPow = new long[2][MAX_NODE + 1];
    public static long[] tH = new long[2];
    public static long[] iH = new long[2];
    public static int[] value = new int[MAX_NODE + 1];
    public static String str = " ";
    public static int ans = 0;

    public static int toInt(char c){
        return c - 'a' + 1;
    }

    public static void DFS(int idx, int depth, long h0, long h1, int val){ 
        value[depth] = val;
        if(depth <= str.length()){
            h0 = (h0 + val * pPow[0][str.length() - depth]) % MOD[0];
            h1 = (h1 + val * pPow[1][str.length() - depth]) % MOD[1];
        }
        else{
            h0 = (h0 * P[0] - value[depth - str.length()] * pPow[0][str.length()] + val) % MOD[0];
            h1 = (h1 * P[1] - value[depth - str.length()] * pPow[1][str.length()] + val) % MOD[1];
            if(h0 < 0){
                h0 += MOD[0];
            }
            
            if(h1 < 0){
                h1 += MOD[1];
            }
        }

        if(h0 == tH[0] && h1 == tH[1]){
            ans++;
        }

        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            node postNode= nodeList[idx].get(i);
            DFS(postNode.idx, depth + 1, h0, h1, postNode.weight);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        str = String.valueOf(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            char c = String.valueOf(st.nextToken()).charAt(0);
            nodeList[start].add(new node(end, toInt(c)));
        }

        for(int k = 0 ; k < 2 ; k++){
            pPow[k][0] = 1;
            for(int i = 1 ; i < n ; i++){
                pPow[k][i] = (pPow[k][i - 1] * P[k]) % MOD[k];
            }
        }

        for(int k = 0 ; k < 2 ; k++){
            for(int i = 0 ; i < str.length() ; i++){
                tH[k] = ( tH[k] + toInt(str.charAt(i)) * pPow[k][str.length() - 1 - i] ) % MOD[k];
            }
        }

        DFS(1, 0, 0, 0, 0);
        System.out.print(ans);
    }
}