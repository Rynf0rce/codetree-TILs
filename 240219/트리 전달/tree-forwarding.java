import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] DP = new int[MAX_NODE + 1];

    public static void DFS(int idx){
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            DP[postIdx] += DP[idx];
            DFS(postIdx);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int root = -1;
        for(int i = 1 ; i <= n ; i++){
            int end = Integer.parseInt(st.nextToken());
            if(end == -1){
                root = i;
            }
            else{
                nodeList[end].add(i);
            }
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            DP[idx] = weight;
        }

        DFS(root);
        for(int i = 1 ; i <= n ; i++){
            System.out.print(DP[i] + " ");
        }
    }
}