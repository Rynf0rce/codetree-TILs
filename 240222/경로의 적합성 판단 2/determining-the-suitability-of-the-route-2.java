import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static int[] uf = new int[MAX_NODE + 1];

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        uf[rootA] = rootB;
    }

    public static int find(int a){
        if(uf[a] == a){
            return a;
        }
        int rootIdx = find(uf[a]);
        uf[a] = rootIdx;
        return rootIdx;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int preIdx = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i < k ; i++){
            int idx = Integer.parseInt(st.nextToken());
            if(find(preIdx) != find(idx)){
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(1);
    }
}