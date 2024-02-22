import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static int[] uf = new int[MAX_NODE + 1];
    public static TreeSet<Integer> rootSet = new TreeSet<>();

    public static int find(int i){
        if(uf[i] == i){
            return i;
        }
        int rootIdx = find(uf[i]);
        uf[i] = rootIdx;
        return rootIdx;
    }

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA > rootB){
            uf[rootA] = rootB;
        }
        else{
            uf[rootB] = rootA;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            uf[i] = i;
        }

        for(int i = 2 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            union(start, end);
        }
        
        for(int i = 1 ; i <= n ; i++){
            rootSet.add(find(i));
            if(rootSet.size() == 2){
                break;
            }
        }

        System.out.print(rootSet.first() + " " + rootSet.last());
    }
}