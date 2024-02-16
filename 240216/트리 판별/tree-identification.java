import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_NODE = 10000;
    public static HashSet<Integer> nodeSet = new HashSet<>();
    public static ArrayList<Integer>[] nodeList = new ArrayList[MAX_NODE + 1];
    public static int[] fan_in = new int[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];

    public static void traversal(int idx){
        if(nodeList[idx] == null){
            return;
        }

        for(int i = 0 ; i < nodeList[idx].size() ; i++){
            int postIdx = nodeList[idx].get(i);
            if(!visited[postIdx]){
                visited[postIdx] = true;
                traversal(postIdx);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int m = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(nodeList[start] == null){
                nodeList[start] = new ArrayList<>();
            }
            nodeList[start].add(end);
            nodeSet.add(start);
            nodeSet.add(end);
            fan_in[end]++;
        }

        int root = 0;
        int cnt = nodeSet.size();
        for(Integer nodeNum : nodeSet){
            if(fan_in[nodeNum] == 1){
                cnt--;
            }
            else if(fan_in[nodeNum] == 0){
                root = nodeNum;
            }
        }

        if(cnt != 1){
            System.out.print(0);
            System.exit(0);
        }

        visited[root] = true;
        traversal(root);

        for(Integer nodeNum : nodeSet){
            if(!visited[nodeNum]){
                System.out.print(0);
                System.exit(0);
            }
        }

        System.out.print(1);
    }
}