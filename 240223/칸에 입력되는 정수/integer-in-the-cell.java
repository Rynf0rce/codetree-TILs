import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_ROCK = 100000;
    public static int[] uf = new int[MAX_ROCK + 1];

    public static int find(int idx){
        if(uf[idx] == idx){
            return idx;
        }
        return uf[idx] = find(uf[idx]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
        }
        
        int ans = 0;
        for(int i = 0 ; i < m ; i++){
            int k = Integer.parseInt(br.readLine());
            int root = find(k);
            if(root == 0){
                break;
            }
            ans++;
            int lowRoot = find(root - 1);
            uf[root] = lowRoot;
        }
        System.out.print(ans);
        
    }
}