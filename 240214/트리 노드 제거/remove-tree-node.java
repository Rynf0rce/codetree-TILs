import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 50;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] parents = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int ans = 0;

    public static void traversal(int idx){
        if(nodeList[idx].isEmpty()){
            return;
        }

        boolean isLeaf = true;
        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int curIdx = nodeList[idx].get(i);
            if(!visited[curIdx]){
                visited[curIdx] = true;
                isLeaf = false;
                traversal(curIdx);
            }
        }

        if(isLeaf){
            // System.out.println(idx);
            ans++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            int idx = Integer.parseInt(st.nextToken());
            parents[i] = idx;
            if(idx == -1){
                root = i;
                parents[i] = i;
            }
            else{
                nodeList[i].add(idx);
                nodeList[idx].add(i);
            }
        }

        int removeIdx = Integer.parseInt(br.readLine());
        nodeList[removeIdx].clear();
        for(int i = 0 ; i < n ; i++){
            nodeList[i].remove(Integer.valueOf(removeIdx));
        }

        visited[root] = true;
        traversal(root);

        System.out.print(ans);
    }
}