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

    public static boolean chackAndMake(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return false;
        }

        if(enemy[a] != 0){
            union(enemy[rootA], rootB);
        }

        if(enemy[b] != 0){
            union(rootA, enemy[rootB]);
        }
        
        // After union with a and b, must define each roots as enemy;
        rootA = find(rootA);
        rootB = find(rootB);
        enemy[rootA] = rootB;
        enemy[rootB] = rootA;
        return true;
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
            if(!chackAndMake(a, b)){
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(1);
    }
}