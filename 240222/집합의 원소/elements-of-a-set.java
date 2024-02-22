import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static int[] uf = new int[MAX_NODE + 1];

    public static int find(int a){
        if(uf[a] == a){
            return a;
        }
        int rootIdx = find(uf[a]);
        uf[a] = rootIdx;
        return rootIdx;
    }

    public static void union(int a, int b){
        int root_A = find(a);
        int root_B = find(b);
        uf[root_A] = root_B;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
        }

        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());;

            
            if(order == 0){
                union(a, b);
            }
            else{
                if(find(a) == find(b)){
                    sb.append(1 + "\n");
                }
                else{
                    sb.append(0 + "\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}