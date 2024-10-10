import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int total_depth = 0;

    public static void traversal(int idx, int depth){
        boolean isLeaf = true;

        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int curIdx = nodeList[idx].get(i);
            if(!visited[curIdx]){
                isLeaf = false;
                visited[curIdx] = true;
                traversal(curIdx, depth + 1);
            }
        }

        if(isLeaf){
            total_depth += depth;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        visited[1] = true;
        traversal(1, 0);

        System.out.println(total_depth % 2);
    }
}