import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] parents = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];

    public static void traversal(int x){
        for(int i = 0 ; i < nodeList[x].size() ; i++){
            int curIdx = nodeList[x].get(i);
            if(!visited[curIdx]){
                visited[curIdx] = true;
                parents[curIdx] = x;
                traversal(curIdx);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            nodeList[i] = new ArrayList<Integer>();
        }

        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodeList[start].add(end);
            nodeList[end].add(start);
        }

        visited[1] = true;
        traversal(1);

        for(int i = 2 ; i <= n ; i++){
            System.out.println(parents[i]);
        }
    }
}