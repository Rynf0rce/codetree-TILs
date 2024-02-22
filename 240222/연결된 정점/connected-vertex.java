import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static int[] uf = new int[MAX_NODE + 1];
    public static int[] cnt = new int[MAX_NODE + 1];

    public static int find(int a){
        if(uf[a] == a){
            return a;
        }
        cnt[uf[a]] += cnt[a];
        cnt[a] = 0;
        int rootIdx = find(uf[a]);
        return rootIdx;
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        uf[rootA] = rootB;
        cnt[rootB] += cnt[rootA];
        cnt[rootA] = 0;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
            cnt[i] = 1;
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            char order = st.nextToken().charAt(0);
            if(order == 'x'){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            else{
                int a = Integer.parseInt(st.nextToken());
                int root = find(a);
                System.out.println(cnt[root]);
            }
        }
    }
}