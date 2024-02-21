import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 50000;
    public static final int MAX_DEPTH = (int)(Math.log(50000) / Math.log(2)) + 1;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[][] sparseTable = new int[MAX_DEPTH + 1][MAX_NODE + 1];
    public static int[] depth = new int[MAX_NODE + 1];
    public static int n = -1;
    public static int d = -1;

    public static void bfs(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(visited[postIdx]){
                continue;
            }
            visited[postIdx] = true;
            depth[postIdx] = depth[idx] + 1;
            sparseTable[0][postIdx] = idx;
            bfs(postIdx);
        }
    }

    public static void makeTable(){
        for(int i = 1; i <= d ; i++){
            for(int j = 1 ; j <= n ; j++){
                sparseTable[i][j] = sparseTable[i - 1][sparseTable[i - 1][j]];
            }
        }
    }

    public static int lca(int a, int b){
        if(depth[a] < depth[b]){
            int temp = b;
            b = a;
            a = temp;
        }

        for(int i = d ; i >= 0 ; i--){
            if(depth[a] == depth[b]){
                break;
            }
            else if(depth[a] - depth[b] >= (1 << i)){
                a = sparseTable[i][a];
            }
        }

        if(a == b){
            return a;
        }

        for(int i = d ; i >= 0 ; i--){
            if(sparseTable[i][a] != sparseTable[i][b]){
                a = sparseTable[i][a];
                b = sparseTable[i][b];
            }
        }
        return sparseTable[0][a];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        d = (int)(Math.log(n) / Math.log(2));
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        sparseTable[0][1] = 1;
        depth[1] = 1;
        visited[1] = true;
        bfs(1);

        makeTable();

        int q = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(lca(a, b));
        }

        // for(int i = 0 ; i <= d ; i++){
        //     for(int j = 1 ; j <= n ; j++){
        //         System.out.print(sparseTable[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }
}