import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static int[] uf = new int[MAX_NODE + 1];
    
    public static int find(int idx){
        if(uf[idx] == idx){
            return idx;
        }
        return uf[idx] = find(uf[idx]);
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        uf[rootA] = rootB;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
        }

        int ans = n;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int j = a;
            while(j < b){
                int root = find(j);
                if(root >= b){
                    break;
                }
                union(j, b);
                ans--;
                j = root + 1;
            }
            sb.append(ans + "\n");
        }

        bw.write(sb.toString()); 
        br.close();
        bw.close();
    }
}