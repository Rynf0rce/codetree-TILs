import java.util.*;
import java.io.*;

class edge{
    int idx;
    int weight;

    public edge(int idx, int weight){
        this.idx = idx;
        this.weight = weight;
    }
}

public class Main {
    public static final int MAX_NODE = 100000;
    public static ArrayList<edge>[] edgeList = new ArrayList[MAX_NODE + 1];
    public static boolean[] visited = new boolean[MAX_NODE + 1];
    public static int[] lengthArr = new int[MAX_NODE + 1];

    public static void traversal(int x){
        for(int i = 0 ; i < edgeList[x].size() ; i++){
            edge curEdge = edgeList[x].get(i);
            if(!visited[curEdge.idx]){
                visited[curEdge.idx] = true;
                lengthArr[curEdge.idx] = lengthArr[x] + curEdge.weight;
                traversal(curEdge.idx);
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= n ; i++){
            edgeList[i] = new ArrayList<>();
        }

        for(int i = 1 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeList[start].add(new edge(end, weight));
            edgeList[end].add(new edge(start, weight));
        }

        visited[1] = true;
        traversal(1);
        
        int maxIdx = 0;
        int maxWeight = 0;
        for(int i = 1  ; i <= n ; i++){
            if(maxWeight < lengthArr[i]){
                maxWeight = lengthArr[i];
                maxIdx = i;
            }
            lengthArr[i] = 0;
            visited[i] = false;
        }

        visited[maxIdx] = true;
        traversal(maxIdx);

        maxWeight = 0;
        for(int i = 1 ; i <= n ; i++){
            maxWeight = Math.max(maxWeight, lengthArr[i]);
        }

        System.out.print(maxWeight);
    }
}