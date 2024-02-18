import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] edgeList = new ArrayList[MAX_NODE + 1];
    public static int[] nodeArr = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] DP = new int[MAX_NODE + 1];
    public static int[] parents = new int[MAX_NODE + 1];
    public static int n = -1;

    public static void traversal(int idx){
        for(int i = 0 ; i < edgeList[idx].size() ; i++){
            int curIdx = edgeList[idx].get(i);
            if(visited[curIdx]){
                continue;
            }

            visited[curIdx] = true;
            parents[curIdx] = idx;
            traversal(curIdx);
        }
        
        DP[idx] = nodeArr[idx];
        for(int i = 0 ; i < edgeList[idx].size() ; i++){
            int curIdx = edgeList[idx].get(i);
            if(parents[curIdx] == idx && DP[curIdx] > 0){
                DP[idx] += DP[curIdx];
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            edgeList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 2 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if(t == 0){
                a *= -1;
            }
            
            edgeList[i].add(p);
            edgeList[p].add(i);
            nodeArr[i] = a;
        }

        visited[1] = true;
        traversal(1);
        System.out.println(DP[1]);
    }
}