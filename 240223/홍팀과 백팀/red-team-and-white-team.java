import java.util.*;
import java.io.*;

public class Main {
    public static int MAX_PEOPLE = 100000;
    public static int[] enemy = new int[MAX_PEOPLE + 1];
    public static int[] uf = new int[MAX_PEOPLE + 1];
    
    public static int find(int idx){
        if(uf[idx] == idx){
            return idx;
        }
        int rootIdx = find(uf[idx]);
        uf[idx] = rootIdx;
        return rootIdx;
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        uf[rootA] = rootB;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
        }

        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB){
                System.out.print(0);
                System.exit(0);
            }

            if(enemy[a] == 0 && enemy[b] == 0){
                enemy[a] = b;
                enemy[b] = a;
            }
            else if(enemy[a] != 0 && enemy[b] == 0){
                union(enemy[a], b);
                enemy[b] = a;
            }
            else if(enemy[a] == 0 && enemy[b] != 0){
                union(a, enemy[b]);
                enemy[a] = b;
            }
            else{
                union(a, enemy[b]);
                union(b, enemy[a]);

                if(find(a) == find(b)){
                    System.out.print(0);
                    System.exit(0);
                }
            }
        }
        System.out.println(1);
    }
}